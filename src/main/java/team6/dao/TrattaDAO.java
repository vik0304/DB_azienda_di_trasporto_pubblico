package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Tratta;
import team6.exeptions.NotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public class TrattaDAO {
    private final EntityManager entityManager;

    public TrattaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Tratta tratta) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(tratta);
        transaction.commit();
    }

    public Tratta findById(UUID id) {
        Tratta found = entityManager.find(Tratta.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        Tratta found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }

    public List<Tratta> findAll() { return null; }

    public void update(Tratta tratta) {}

    public void delete(String id) {}

    public List<Tratta> findByPartenza(String partenza) { return null; }

    public List<Tratta> findByCapolinea(String capolinea) { return null; }

    public List<Tratta> findByPartenzaAndCapolinea(String partenza, String capolinea) { return null; }

    public List<Tratta> findByDurataPrevista(BigInteger durataPrevista) { return null; }
}