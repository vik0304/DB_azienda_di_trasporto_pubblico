package team6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team6.entities.*;
import team6.exeptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
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

    public void creaTitoloDiViaggioDaInput(Scanner scanner) {
        System.out.println(" tipo di titolo di viaggio ");
        System.out.println("1. Biglietto");
        System.out.println("2. Abbonamento");
        String scelta = scanner.nextLine();

        try {
            System.out.println("Inserisci l'ID (UUID) del venditore:");
            UUID venditoreId = UUID.fromString(scanner.nextLine());
            VenditoreDAO venditoreDAO = new VenditoreDAO(this.entityManager);
            Venditore venditore = venditoreDAO.findById(venditoreId);

            if ("1".equals(scelta)) {
                Biglietto nuovoBiglietto = new Biglietto(LocalDate.now(), venditore, false);
                save(nuovoBiglietto);
                System.out.println("Nuovo biglietto creato con ID: " + nuovoBiglietto.getId());
            } else if ("2".equals(scelta)) {
                System.out.println("Inserisci l'ID della tessera:");
                UUID tesseraId = UUID.fromString(scanner.nextLine());
                TesseraDAO tesseraDAO = new TesseraDAO(this.entityManager);
                Tessera tessera = tesseraDAO.findById(tesseraId);

                if (tessera.getDataScadenza().isBefore(LocalDate.now())) {
                    System.err.println("La tessera è scaduta. ");
                    return;
                }

                System.out.println("Scegli il tipo di abbonamento:");
                System.out.println("1. SETTIMANALE");
                System.out.println("2. MENSILE");
                String tipoAbbonamentoScelta = scanner.nextLine();
                TipoAbbonamento tipoAbbonamento;
                if ("1".equals(tipoAbbonamentoScelta)) {
                    tipoAbbonamento = TipoAbbonamento.SETTIMANALE;
                } else {
                    tipoAbbonamento = TipoAbbonamento.MENSILE;
                }

                Abbonamento nuovoAbbonamento = new Abbonamento(tipoAbbonamento, tessera, LocalDate.now(), venditore);
                save(nuovoAbbonamento);
                System.out.println("Nuovo abbonamento creato con ID: " + nuovoAbbonamento.getId());

            } else {
                System.out.println("Scelta non valida.");
            }
        } catch (NotFoundException e) {
            System.err.println("Entità non trovata (Venditore o Tessera). Impossibile procedere.");
        } catch (IllegalArgumentException e) {
            System.err.println("ID non valido.");
        }
    }

    public long trovaBigliettiVidimatiPerMezzo(long idMezzo) {
        TypedQuery<Biglietto> query = entityManager.createQuery(
            "SELECT b FROM Biglietto b WHERE b.validato = true AND b.veicolo.id = :idMezzo",
            Biglietto.class
        );
        query.setParameter("idMezzo", idMezzo);
        return query.getResultList().size();
    }

    public long trovaBigliettiVidimatiPerPeriodo(LocalDate dataInizio, LocalDate dataFine) {
        TypedQuery<Biglietto> query = entityManager.createQuery(
            "SELECT b FROM Biglietto b WHERE b.validato = true AND b.dataAcquisto BETWEEN :dataInizio AND :dataFine",
            Biglietto.class
        );
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        return query.getResultList().size();
    }

    public long titoliByPeriodo (LocalDate inizioPeriodo, LocalDate finePeriodo){
        TypedQuery<TitoloDiViaggio> query = entityManager.createQuery("SELECT t FROM TitoloDiViaggio t WHERE t.dataAcquisto < :start AND t.dataAcquisto > :end", TitoloDiViaggio.class);
        query.setParameter("start", inizioPeriodo);
        query.setParameter("end", finePeriodo);
        return query.getResultList().size();
    }

    public long titoliByVenditore (Venditore venditore){
        TypedQuery<TitoloDiViaggio> query = entityManager.createQuery("SELECT t FROM TitoloDiViaggio t WHERE t.venditore = :venditore", TitoloDiViaggio.class);
        query.setParameter("venditore", venditore);
        return query.getResultList().size();
    }

    public void trovaBigliettiPerData(Scanner scanner) {
        System.out.println("Inserisci la data per cui vuoi cercare i biglietti (formato YYYY-MM-DD):");
        String dataInput = scanner.nextLine();
        try {
            LocalDate dataRicerca = LocalDate.parse(dataInput);
            TypedQuery<Biglietto> query = entityManager.createQuery(
                    "SELECT b FROM Biglietto b WHERE b.dataAcquisto = :dataRicerca",
                    Biglietto.class
            );
            query.setParameter("dataRicerca", dataRicerca);
            List<Biglietto> biglietti = query.getResultList();

            if (biglietti.isEmpty()) {
                System.out.println("Nessun biglietto trovato per la data " + dataRicerca);
            } else {
                System.out.println("Biglietti trovati per la data " + dataRicerca + ":");
                biglietti.forEach(biglietto -> {
                    System.out.println("- ID Biglietto: " + biglietto.getId());
                });
            }
        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("Formato data non valido. Usa il formato YYYY-MM-DD.");
        } catch (Exception e) {
            System.err.println("Si è verificato un errore durante la ricerca: " + e.getMessage());
        }
    }
}
