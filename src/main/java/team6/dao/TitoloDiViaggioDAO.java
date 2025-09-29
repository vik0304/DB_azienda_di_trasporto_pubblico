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

    public void save (TitoloDiViaggio titoloDiViaggio){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(titoloDiViaggio);
        transaction.commit();
        System.out.println("Il titolo " + titoloDiViaggio.getId() + " è stato aggiunto.");
    }

    public TitoloDiViaggio findById(UUID id){
        TitoloDiViaggio found = entityManager.find(TitoloDiViaggio.class, id);
        if(found==null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete (UUID id){
        TitoloDiViaggio found = this.findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Il titolo " + found.getId() + " è stato rimosso.");
    }
}
