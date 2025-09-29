package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Tessera;
import team6.exeptions.NotFoundException;

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
}
