package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Parameter;
import jakarta.persistence.TypedQuery;
import team6.entities.Percorrenza;
import team6.entities.Tratta;
import team6.entities.Venditore;
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

    public void elimina(Scanner scanner, PercorrenzaDAO pDao){
        System.out.println("Inserisci l'ID della percorrenza da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            pDao.findAndDelete(id);
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Percorrenza non trovata");
        }
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
