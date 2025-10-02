package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Manutenzione;
import team6.entities.Utente;
import team6.entities.Veicolo;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Scanner;
import java.util.UUID;

public class ManutenzioneDAO {

    // LISTA ATTRIBUTI
    private final EntityManager entityManager;

    // LISTA COSTRUTTORI
    public ManutenzioneDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // LISTA METODI
    public void save(Manutenzione manutenzione){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(manutenzione);
        transaction.commit();

        System.out.println("La manutenzione " + manutenzione.getId() + " è stata aggiunta");
    }

    public Manutenzione findById(UUID id){
        Manutenzione found = entityManager.find(Manutenzione.class, id);
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id){
        Manutenzione found = this.findById(id);
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);
        transaction.commit();
        System.out.println("La manutenzione " + found.getId() + " è stata rimossa");
    }

    public void elimina(Scanner scanner, ManutenzioneDAO mDao){
        System.out.println("Inserisci l'ID della manutenzione da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            mDao.findAndDelete(id);
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Manutenzione non trovata");
        }
    }

    public void createManutenzione(Scanner s, VeicoloDAO vd){
        System.out.println("Inserisci l'id del veicolo in manutenzione");
        long id = Long.parseLong(s.nextLine());
        Veicolo veicolo = vd.findById(id);
        System.out.println("Inserisci la data di inizio del periodo di manutenzione (formato YYYY-MM-DD):");
        String dataInputStart = s.nextLine();
        System.out.println("Inserisci la data di fine del periodo di manutenzione (formato YYYY-MM-DD):");
        String dataInputEnd = s.nextLine();
        try {
            LocalDate dataRicercaStart = LocalDate.parse(dataInputStart);
            LocalDate dataRicercaEnd = LocalDate.parse(dataInputEnd);
            Manutenzione manutenzione = new Manutenzione(dataRicercaStart, dataRicercaEnd, veicolo);
            save(manutenzione);
            System.out.println("Manutenzione salvata con successo! Verrai riportato al menu.");
        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("Formato data non valido. Usa il formato YYYY-MM-DD. Verra riportato al menu.");
        } catch (Exception e) {
            System.err.println("Si è verificato un errore durante la ricerca: " + e.getMessage() + " verrai riportato al menu.");
        }
    }
}
