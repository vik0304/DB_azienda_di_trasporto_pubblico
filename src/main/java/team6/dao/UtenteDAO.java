package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import team6.entities.Utente;
import team6.exeptions.NotFoundException;

import java.util.Scanner;
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

    public String userType(UUID id){
        TypedQuery<String> query = entityManager.createQuery("SELECT u.tipoUtente FROM Utente u WHERE u.codiceFiscale = :id", String.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void elimina(Scanner scanner, UtenteDAO uDao){
        System.out.println("Inserisci l'ID della utente da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            uDao.findAndDelete(id);
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Utente non trovato");
        }
    }
}
