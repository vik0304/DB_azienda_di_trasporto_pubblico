package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team6.entities.Veicolo;
import team6.exeptions.NotFoundException;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class VeicoloDAO {
    private final EntityManager entityManager;

    public VeicoloDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Veicolo veicolo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(veicolo);
        transaction.commit();
    }

    public Veicolo findById(long id) {
        Veicolo found = entityManager.find(Veicolo.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(long id) {
        Veicolo found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }

    public void elimina(Scanner scanner, VeicoloDAO vDao){
        System.out.println("Inserisci l'ID del veicolo da eliminare");
        try {
            long id = scanner.nextLong();
            vDao.findAndDelete(id);
        } catch (IllegalArgumentException e){
            System.out.println("ID non valido");
        } catch (NotFoundException e){
            System.out.println("Veicolo non trovato");
        }
    }

    public void creaVeicoloDaInput(Scanner scanner) {
        System.out.println(" tipo di mezzo (es. autobus, tram):");
        String tipoMezzo = scanner.nextLine();

        System.out.println("Inserisci la capienza del mezzo:");
        int capienza = Integer.parseInt(scanner.nextLine());

        System.out.println("Il mezzo è in manutenzione? (true/false):");
        boolean inManutenzione = Boolean.parseBoolean(scanner.nextLine());

        Veicolo nuovoVeicolo = new Veicolo(tipoMezzo, capienza, inManutenzione);
        nuovoVeicolo.tipoMezzo = tipoMezzo;
        nuovoVeicolo.capienza = capienza;
        nuovoVeicolo.inManutenzione = inManutenzione;

        save(nuovoVeicolo);
        System.out.println("Nuovo veicolo creato con ID: " + nuovoVeicolo.getId());
    }

    public void cercaVeicoloPerIdDaInput(Scanner scanner) {
        System.out.println("Inserisci l'ID del veicolo:");
        try {
            long veicoloId = Long.parseLong(scanner.nextLine());
            Veicolo veicolo = findById(veicoloId);
            System.out.println("Veicolo trovato:");
            System.out.println("- ID: " + veicolo.getId());
            System.out.println("- Tipo mezzo: " + veicolo.tipoMezzo);
            System.out.println("- Capienza: " + veicolo.capienza);
            System.out.println("- In manutenzione: " + (veicolo.inManutenzione ? "Sì" : "No"));
        } catch (NumberFormatException e) {
            System.err.println("ID veicolo non valido.");
        } catch (team6.exeptions.NotFoundException e) {
            System.err.println("Veicolo non trovato.");
        }
    }

    public List<Veicolo> findAll() { return null; }

    public void update(Veicolo veicolo) {}

    public void delete(String id) {}

    public List<Veicolo> findByTipoMezzo(String tipoMezzo) { return null; }

    public List<Veicolo> findByInManutenzione(boolean inManutenzione) { return null; }
}