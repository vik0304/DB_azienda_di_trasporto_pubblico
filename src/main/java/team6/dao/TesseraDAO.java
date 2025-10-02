package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team6.entities.Abbonamento;
import team6.entities.Tessera;
import team6.entities.Utente;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class TesseraDAO {

    // LISTA ATTRIBUTI
    private final EntityManager entityManager;

    // LISTA COSTRUTTORI
    public TesseraDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // LISTA METODI
    public void save(Tessera tessera){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(tessera);
        transaction.commit();

        System.out.println("La tessera " + tessera.getId() + " è stata aggiunta");
    }

    public Tessera findById(UUID id){
        Tessera found = entityManager.find(Tessera.class, id);
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id){
        Tessera found = this.findById(id);
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.remove(found);

        transaction.commit();

        System.out.println("La tessera " + found.getId() + " è stata rimossa");
    }

    public void elimina(Scanner scanner, TesseraDAO tessDao){
        System.out.println("Inserisci l'ID della tessera da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            tessDao.findAndDelete(id);
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Tessera non trovata");
        }
    }

    public Abbonamento abbonamentiAttiviPerTessera(UUID idTessera){
        TypedQuery<Abbonamento> query = entityManager.createQuery("SELECT a FROM Abbonamento a WHERE a.tessera.id = :tesseraId AND a.dataScadenza > :oggi", Abbonamento.class);
        query.setParameter("tesseraId", idTessera);
        query.setParameter("oggi", LocalDate.now());
        return query.getSingleResult();
    }

    public void creaTesseraDaInput(Scanner scanner) {
        try {
            System.out.println("Inserisci l'ID (UUID) dell'utente per associare la tessera:");
            UUID utenteId = UUID.fromString(scanner.nextLine());

            UtenteDAO utenteDAO = new UtenteDAO(this.entityManager);
            Utente utente = utenteDAO.findById(utenteId);

            Tessera nuovaTessera = new Tessera();
            nuovaTessera.setId(UUID.randomUUID());
            nuovaTessera.setDataDiEmissione(LocalDate.now());
            nuovaTessera.setDataScadenza(LocalDate.now().plusYears(1));
            nuovaTessera.setIdUtente(utente);

            save(nuovaTessera);

        } catch (NotFoundException e) {
            System.err.println("Utente non trovato. Impossibile creare la tessera.");
        } catch (IllegalArgumentException e) {
            System.err.println("ID utente non valido. Assicurati di inserire un UUID corretto.");
        }
    }

    public void cercaTesseraPerIdDaInput(Scanner scanner) {
        System.out.println("Inserisci l'ID (UUID) della tessera:");
        try {
            UUID tesseraId = UUID.fromString(scanner.nextLine());
            Tessera tessera = findById(tesseraId);
            System.out.println("Tessera trovata:");
            System.out.println("- ID: " + tessera.getId());
            System.out.println("- Data emissione: " + tessera.getDataDiEmissione());
            System.out.println("- Data scadenza: " + tessera.getDataScadenza());
            System.out.println("- Proprietario: " + tessera.getIdUtente().getNome() + " " + tessera.getIdUtente().getCognome());
        } catch (IllegalArgumentException e) {
            System.err.println("ID tessera non valido.");
        } catch (NotFoundException e) {
            System.err.println("Tessera non trovata.");
        }
    }

    public void cercaAbbonamentiAttiviPerTesseraDaInput(Scanner scanner) {
        System.out.println("Inserisci l'ID della tessera:");
        try {
            UUID tesseraId = UUID.fromString(scanner.nextLine());
            team6.entities.Abbonamento abbonamento = abbonamentiAttiviPerTessera(tesseraId);
            if (abbonamento != null) {
                System.out.println("Abbonamento attivo trovato:");
                System.out.println("- ID: " + abbonamento.getId());
                System.out.println("- Tipo: " + abbonamento.getTipoAbbonamento());
                System.out.println("- Data scadenza: " + abbonamento.getDataScadenza());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("ID tessera non valido.");
        } catch (Exception e) {
            System.out.println("Nessun abbonamento attivo trovato per questa tessera.");
        }
    }
}
