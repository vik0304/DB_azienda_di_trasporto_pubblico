package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.*;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Scanner;
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

    public void createVenditore(Scanner s){
        int selected;
        System.out.println("Desideri inserire un distributore automatico o un rivenditore autorizzato?");
        System.out.println("1- distributore automatico");
        System.out.println("2- rivenditore autorizzato");
        try {
            selected = Integer.parseInt(s.nextLine());
            if (selected == 1 || selected == 2){
                System.out.println("Inserisci l'indirizzo del venditore:");
                String posizione = s.nextLine();
                if(selected == 1){
                    System.out.println("Il distributore è al momento attivo? (true/false)");
                    boolean statoAttivazione = Boolean.parseBoolean(s.nextLine());
                    DistributoreAutomatico distributoreAutomatico = new DistributoreAutomatico(posizione, statoAttivazione);
                    save(distributoreAutomatico);
                } else {
                    System.out.println("Inserisci il nome del rivenditore autorizzato:");
                    String nome = s.nextLine();
                    RivenditoreAutorizzato rivenditoreAutorizzato = new RivenditoreAutorizzato(posizione, nome);
                    save(rivenditoreAutorizzato);
                }
                System.out.println("Venditore salvato con successo! Verrai riportato al menu.");
            } else {
                System.out.println("Hai selezionato un numero non valido, verrai riportato la menu principale");
            }
        } catch (NumberFormatException e){
            System.out.println("Errore: devi inserire un numero intero positivo.");
        }
    }

    public void elimina(Scanner scanner){
        System.out.println("Inserisci l'ID del venditore da eliminare");
        String iDInput = scanner.nextLine();
        try {
            UUID id = UUID.fromString(iDInput);
            findAndDelete(id);
            System.out.println("Venditore eliminato correttamente");
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Venditore non trovato");
        }
    }
}
