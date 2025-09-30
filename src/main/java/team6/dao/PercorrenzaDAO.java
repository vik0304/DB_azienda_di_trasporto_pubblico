package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Percorrenza;
import team6.entities.Venditore;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PercorrenzaDAO {
    private final EntityManager entityManager;

    public PercorrenzaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Percorrenza percorrenza) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(percorrenza);
            transaction.commit();
            System.out.println("La percorrenza " + percorrenza.getId() + " è stato aggiunta.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Percorrenza findById(UUID id) {
        Percorrenza found = entityManager.find(Percorrenza.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        Percorrenza found = this.findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(found);
            transaction.commit();
            System.out.println("La percorrenza " + found.getId() + " è stato rimossa.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<Percorrenza> findAll() { return null; }

    public void update(Percorrenza percorrenza) {}

    public void delete(String id) {}

    public List<Percorrenza> findByIdMezzo(String idMezzo) { return null; }

    public List<Percorrenza> findByIdTratta(String idTratta) { return null; }

    public List<Percorrenza> findByDataPartenza(LocalDate dataPartenza) { return null; }

    public List<Percorrenza> findByDateRange(LocalDate startDate, LocalDate endDate) { return null; }
}