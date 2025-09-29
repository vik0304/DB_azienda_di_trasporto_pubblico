package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Tratta;
import team6.entities.Veicolo;
import team6.exeptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class VeicoloDAO {
    private final EntityManager entityManager;

    public VeicoloDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void save(Veicolo veicolo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(veicolo);
        transaction.commit();
        System.out.println("Il veicolo " + veicolo.getId() + " è stato aggiunto.");
    }

    public Veicolo findById(long id) {
        Veicolo found = entityManager.find(Veicolo.class, id);
        if(found==null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete (long id){
        Veicolo found = this.findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Il veicolo " + found.getId() + " è stato rimosso.");
    }

    public List<Veicolo> findAll() { return null; }

    public void update(Veicolo veicolo) {}

    public void delete(String id) {}

    public List<Veicolo> findByTipoMezzo(String tipoMezzo) { return null; }

    public List<Veicolo> findByInManutenzione(boolean inManutenzione) { return null; }
}