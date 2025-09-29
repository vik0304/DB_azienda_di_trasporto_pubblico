package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Manutenzione;
import team6.entities.Utente;
import team6.exeptions.NotFoundException;

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
}
