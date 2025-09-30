package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.TitoloDiViaggio;
import team6.entities.Venditore;
import team6.exeptions.NotFoundException;

import java.util.UUID;

public class VenditoreDAO {
    private final EntityManager entityManager;

    public VenditoreDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void save(Venditore venditore) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(venditore);
        transaction.commit();
    }

    public Venditore findById(UUID id) {
        Venditore found = entityManager.find(Venditore.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        Venditore found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
