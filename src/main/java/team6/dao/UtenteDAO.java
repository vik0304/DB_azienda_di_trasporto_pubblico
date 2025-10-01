package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Utente;
import team6.exeptions.NotFoundException;

import java.util.UUID;


public class UtenteDAO {
    // LISTA ATTRIBUT0
    private final EntityManager entityManager;

    // LISTA COSTRUTTORI
    public UtenteDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    // METODI
    public void save(Utente utente){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();

        System.out.println("l'utente " + utente.getCodice_fiscale() + " è stato aggiunto");
    }

    public Utente findById(UUID codiceFiscale){
        Utente found = entityManager.find(Utente.class, codiceFiscale);
        if(found==null) throw new NotFoundException(codiceFiscale);
        return found;
    }

    public void findAndDelete(UUID codiceFiscale){
        Utente found = this.findById(codiceFiscale);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);
        transaction.commit();

        System.out.println("L'utente " + found.getCodice_fiscale() + " è stato rimosso");
    }


}
