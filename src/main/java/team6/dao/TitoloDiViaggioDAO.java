package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.TitoloDiViaggio;
import team6.exeptions.NotFoundException;

import java.util.UUID;


public class TitoloDiViaggioDAO {
    private final EntityManager entityManager;

    public TitoloDiViaggioDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(titoloDiViaggio);
        transaction.commit();
    }

    public TitoloDiViaggio findById(UUID id) {
        TitoloDiViaggio found = entityManager.find(TitoloDiViaggio.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        TitoloDiViaggio found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
