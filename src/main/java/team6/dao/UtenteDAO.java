package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team6.entities.Manutenzione;
import team6.entities.TipoUtente;
import team6.entities.Utente;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Scanner;
import java.util.UUID;


public class UtenteDAO {
    // LISTA ATTRIBUT0
    private final EntityManager entityManager;

    // LISTA COSTRUTTORI
    public UtenteDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    // METODI
    public void save(Utente utente){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();

        System.out.println("l'utente " + utente.getCodice_fiscale() + " è stato aggiunto");
    }

    public Utente findById(UUID codiceFiscale){
        Utente found = entityManager.find(Utente.class, codiceFiscale);
        if(found==null) throw new NotFoundException(codiceFiscale);
        return found;
    }

    public void findAndDelete(UUID codiceFiscale){
        Utente found = this.findById(codiceFiscale);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);
        transaction.commit();

        System.out.println("L'utente " + found.getCodice_fiscale() + " è stato rimosso");
    }

    public TipoUtente userType(UUID id){
        TypedQuery<TipoUtente> query = entityManager.createQuery("SELECT u.tipoUtente FROM Utente u WHERE u.codiceFiscale = :id", TipoUtente.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void createUtente(Scanner s){
        int selected;
        System.out.println("Desideri inserire un utente o un admin?");
        System.out.println("1- user");
        System.out.println("2- admin");
        try {
            selected = Integer.parseInt(s.nextLine());
            if (selected == 1 || selected == 2){
                System.out.println("Inserisci il nome dell'utente:");
                String nome = s.nextLine();
                System.out.println("Inserisci il cognome dell'utente:");
                String cognome = s.nextLine();
                System.out.println("Inserisci la data di nascita dell'utente (formato YYYY-MM-DD):");
                String dataInputStart = s.nextLine();
                try {
                    LocalDate dataRicercaStart = LocalDate.parse(dataInputStart);
                    if(selected == 1){
                        TipoUtente tipoUtente = TipoUtente.USER;
                        Utente utente = new Utente(nome, cognome, dataRicercaStart, tipoUtente);
                        save(utente);
                        System.out.println("User inserito nel sistema.");
                    } else {
                        TipoUtente tipoUtente = TipoUtente.ADMIN;
                        Utente utente = new Utente(nome, cognome, dataRicercaStart, tipoUtente);
                        save(utente);
                        System.out.println("Admin inserito nel sistema.");
                    }
                    System.out.println("Manutenzione salvata con successo! Verrai riportato al menu.");
                } catch (java.time.format.DateTimeParseException e) {
                    System.err.println("Formato data non valido. Usa il formato YYYY-MM-DD. Verra riportato al menu.");
                } catch (Exception e) {
                    System.err.println("Si è verificato un errore durante la ricerca: " + e.getMessage() + " verrai riportato al menu.");
                }
            } else {
                System.out.println("Hai selezionato un numero non valido, verrai riportato la menu principale");
            }
        } catch (NumberFormatException e){
            System.out.println("Errore: devi inserire un numero intero positivo.");
        }
    }

    public void elimina(Scanner scanner){
        System.out.println("Inserisci l'ID della utente da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            findAndDelete(id);
            System.out.println("Utente eliminato correttamente");
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Utente non trovato");
        }
    }

    public void cercaUtentePerIdDaInput(java.util.Scanner scanner) {
        System.out.println("Inserisci l'ID (UUID) dell'utente:");
        try {
            UUID utenteId = UUID.fromString(scanner.nextLine());
            Utente utente = findById(utenteId);
            System.out.println("Utente trovato:");
            System.out.println("- Codice Fiscale: " + utente.getCodice_fiscale());
            System.out.println("- Nome: " + utente.getNome());
            System.out.println("- Cognome: " + utente.getCognome());
            System.out.println("- Data di nascita: " + utente.getDataDiNascita());
            System.out.println("- Tipo: " + utente.getTipoUtente());
        } catch (IllegalArgumentException e) {
            System.err.println("ID utente non valido.");
        } catch (NotFoundException e) {
            System.err.println("Utente non trovato.");
        }
    }
}
