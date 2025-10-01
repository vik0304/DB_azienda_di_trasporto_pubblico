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

    public void creaTesseraDaInput(Scanner scanner) {
        try {
            System.out.println("Inserisci l'ID (UUID) dell'utente per associare la tessera:");
            UUID utenteId = UUID.fromString(scanner.nextLine());

            UtenteDAO utenteDAO = new UtenteDAO(this.entityManager);
            Utente utente = utenteDAO.findById(utenteId);

            Tessera nuovaTessera = new Tessera();
            nuovaTessera.setId(UUID.randomUUID());
            nuovaTessera.setDataDiEmissione(LocalDate.now());
            nuovaTessera.setDataScadenza(LocalDate.now().plusYears(1));
            nuovaTessera.setIdUtente(utente);

            save(nuovaTessera);

        } catch (NotFoundException e) {
            System.err.println("Utente non trovato. Impossibile creare la tessera.");
        } catch (IllegalArgumentException e) {
            System.err.println("ID utente non valido. Assicurati di inserire un UUID corretto.");
        }
    }
    public long abbonamentiAttiviPerTessera(UUID idTessera){
        TypedQuery<Tessera> query = entityManager.createQuery("SELECT a FROM Abbonamento a WHERE a.tessera.id = :tesseraId AND a.dataScadenza > :oggi", Tessera.class);
        query.setParameter("tesseraId", idTessera);
        query.setParameter("oggi", LocalDate.now());
        return query.getResultList().size();
    }
}
