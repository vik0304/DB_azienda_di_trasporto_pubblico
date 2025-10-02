package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Tratta;
import team6.exeptions.NotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
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

    public void elimina(Scanner scanner, TrattaDAO tDao){
        System.out.println("Inserisci l'ID della tratta da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            tDao.findAndDelete(id);
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Tratta non trovata");
        }
    }

    public void trattaCreate(Scanner s){
        System.out.println("Inserisci il punto di partenza della tratta:");
        String partenza = s.nextLine();
        System.out.println("Inserisci il capolinea della tratta");
        String capolinea = s.nextLine();
        System.out.println("Inserisci la durata prevista per la tratta:");
        int durata = Integer.parseInt(s.nextLine());
        Tratta tratta = new Tratta(partenza, capolinea, durata);
        save(tratta);
        System.out.println("La tratta è stata correttamente aggiunta");
    }
}