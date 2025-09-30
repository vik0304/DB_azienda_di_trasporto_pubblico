package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team6.entities.Biglietto;
import team6.entities.TitoloDiViaggio;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class TitoloDiViaggioDAO {
    private final EntityManager entityManager;

    public TitoloDiViaggioDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void save(TitoloDiViaggio titoloDiViaggio) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(titoloDiViaggio);
        transaction.commit();
    }

    public TitoloDiViaggio findById(UUID id) {
        TitoloDiViaggio found = entityManager.find(TitoloDiViaggio.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findAndDelete(UUID id) {
        TitoloDiViaggio found = findById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }

    public List<Biglietto> trovaBigliettiVidimatiPerMezzo(long idMezzo) {
        TypedQuery<Biglietto> query = entityManager.createQuery(
            "SELECT b FROM Biglietto b WHERE b.validato = true AND b.veicolo.id = :idMezzo",
            Biglietto.class
        );
        query.setParameter("idMezzo", idMezzo);
        return query.getResultList();
    }

    public List<Biglietto> trovaBigliettiVidimatiPerPeriodo(LocalDate dataInizio, LocalDate dataFine) {
        TypedQuery<Biglietto> query = entityManager.createQuery(
            "SELECT b FROM Biglietto b WHERE b.validato = true AND b.dataAcquisto BETWEEN :dataInizio AND :dataFine",
            Biglietto.class
        );
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        return query.getResultList();
    }
}
