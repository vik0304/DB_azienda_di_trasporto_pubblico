package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Parameter;
import jakarta.persistence.TypedQuery;
import team6.entities.*;
import team6.exeptions.NotFoundException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PercorrenzaDAO {
    private final EntityManager entityManager;

    public PercorrenzaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Percorrenza percorrenza) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(percorrenza);
        transaction.commit();
    }

    public Percorrenza findById(UUID id) {
        Percorrenza found = entityManager.find(Percorrenza.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        Percorrenza found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }

    public long numPercorrenza(UUID trattaId, UUID mezzoId){
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(p) FROM Percorrenza p WHERE p.tratta.id = :trattaId AND p.mezzo.id = :mezzoId", Long.class
        );
        query.setParameter("trattaId", trattaId);
        query.setParameter("mezzoId", mezzoId);
        return query.getSingleResult();
    }

    public long tempoEffettivoTratta(UUID trattaid, UUID mezzoId){
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT SUM(FUNCTION('TIMESTAMPDIFF', MINUTE, p.dataPartenza, p.dataArrivo)) FROM Percorrenza p WHERE p.tratta.id = :trattaId AND p.mezzo.id = :mezzoId",
                Long.class
        );
        query.setParameter("trattaId", trattaid);
        query.setParameter("mezzoId", mezzoId);
        return query.getSingleResult();
    }

    public void percorrenzaCreate(Scanner s, TrattaDAO traD, VeicoloDAO vd){
        System.out.println("Inserisci l'id del veicolo in manutenzione");
        long id = Long.parseLong(s.nextLine());
        Veicolo veicolo = vd.findById(id);
        System.out.println("Inserisci l'id della tratta che svolge il veicolo.");
        UUID id2 = UUID.fromString((s.nextLine()));
        Tratta tratta = traD.findById(id2);
        System.out.println("Inserisci la data della corsa (formato YYYY-MM-DD):");
        String dataInputStart = s.nextLine();
        try {
            LocalDate dataRicercaStart = LocalDate.parse(dataInputStart);
            System.out.println("Inserisci la durata della corsa");
            int durata = Integer.parseInt(s.nextLine());
            Percorrenza percorrenza = new Percorrenza(veicolo, tratta, dataRicercaStart, durata);
            save(percorrenza);
            System.out.println("Percorrenza salvata con successo! Verrai riportato al menu.");
        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("Formato data non valido. Usa il formato YYYY-MM-DD. Verra riportato al menu.");
        } catch (Exception e) {
            System.err.println("Si è verificato un errore durante la ricerca: " + e.getMessage() + " verrai riportato al menu.");
        }
    }
}
//
//    public List<Percorrenza> findAll() { return null; }
//
//    public void update(Percorrenza percorrenza) {}
//
//    public void delete(String id) {}
//
//    public List<Percorrenza> findByIdMezzo(String idMezzo) { return null; }
//
//    public List<Percorrenza> findByIdTratta(String idTratta) { return null; }
//
//    public List<Percorrenza> findByDataPartenza(LocalDate dataPartenza) { return null; }
//
//    public List<Percorrenza> findByDateRange(LocalDate startDate, LocalDate endDate) { return null; }
