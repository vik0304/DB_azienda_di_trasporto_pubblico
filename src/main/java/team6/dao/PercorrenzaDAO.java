package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Parameter;
import jakarta.persistence.TypedQuery;
import team6.entities.Percorrenza;
import team6.entities.Tratta;
import team6.entities.Venditore;
import team6.exeptions.NotFoundException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PercorrenzaDAO {
    private final EntityManager entityManager;

    public PercorrenzaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Percorrenza percorrenza) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(percorrenza);
        transaction.commit();
    }

    public Percorrenza findById(UUID id) {
        Percorrenza found = entityManager.find(Percorrenza.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        Percorrenza found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }

    public long numPercorrenza(UUID trattaId, UUID veicoloId){
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(p) FROM Percorrenza p WHERE p.tratta.id = :trattaId AND p.veicolo.id = :veicoloId", Long.class
        );
        query.setParameter("trattaId", trattaId);
        query.setParameter("veicoloId", veicoloId);
        return query.getSingleResult();
    }

    public Long tempoEffettivoTratta(UUID trattaId, UUID veicoloId){
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT SUM(p.durataCorsa) FROM Percorrenza p WHERE p.tratta.id = :trattaId AND p.veicolo.id = :veicoloId",
                Long.class
        );
        query.setParameter("trattaId", trattaId);
        query.setParameter("veicoloId", veicoloId);
        return query.getSingleResult();
    }

    public void cercaNumPercorrenzaDaInput(java.util.Scanner scanner) {
        System.out.println("Inserisci l'ID (UUID) della tratta:");
        try {
            UUID trattaId = UUID.fromString(scanner.nextLine());
            System.out.println("Inserisci l'ID (UUID) del veicolo:");
            UUID veicoloId = UUID.fromString(scanner.nextLine());

            long numPercorrenze = numPercorrenza(trattaId, veicoloId);
            System.out.println("Numero di percorrenze della tratta " + trattaId + " effettuate dal veicolo " + veicoloId + ": " + numPercorrenze);
        } catch (IllegalArgumentException e) {
            System.err.println("ID non valido. Assicurati di inserire UUID corretti.");
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca: " + e.getMessage());
        }
    }

    public void cercaTempoEffettivoTrattaDaInput(java.util.Scanner scanner) {
        System.out.println("Inserisci l'ID (UUID) della tratta:");
        try {
            UUID trattaId = UUID.fromString(scanner.nextLine());
            System.out.println("Inserisci l'ID (UUID) del veicolo:");
            UUID veicoloId = UUID.fromString(scanner.nextLine());

            Long tempoTotale = tempoEffettivoTratta(trattaId, veicoloId);
            if (tempoTotale != null) {
                System.out.println("Tempo effettivo totale per la tratta " + trattaId + " con veicolo " + veicoloId + ": " + tempoTotale + " minuti");
            } else {
                System.out.println("Nessuna percorrenza trovata per questa combinazione tratta-veicolo.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("ID non valido. Assicurati di inserire UUID corretti.");
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca: " + e.getMessage());
        }
    }
}
//
//    public List<Percorrenza> findAll() { return null; }
//
//    public void update(Percorrenza percorrenza) {}
//
//    public void delete(String id) {}
//
//    public List<Percorrenza> findByIdMezzo(String idMezzo) { return null; }
//
//    public List<Percorrenza> findByIdTratta(String idTratta) { return null; }
//
//    public List<Percorrenza> findByDataPartenza(LocalDate dataPartenza) { return null; }
//
//    public List<Percorrenza> findByDateRange(LocalDate startDate, LocalDate endDate) { return null; }
