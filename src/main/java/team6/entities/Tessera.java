package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Tessera {
    @Id
    private UUID id;
    @Column(name = "data_di_emissione")
    private LocalDate dataDiEmissione;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente idUtente;
    @Column (name = "data_scadenza")
    private LocalDate dataScadenza;
    @OneToMany(mappedBy = "idTessera")
    private List<Abbonamento> abbonamenti;

    // LISTA COSTRUTTORE
    public Tessera(LocalDate dataDiEmissione, Utente idUtente, List<Abbonamento> abbonamenti){
        this.dataDiEmissione=dataDiEmissione;
        this.idUtente = idUtente;
        this.abbonamenti = abbonamenti;
        this.dataScadenza= dataDiEmissione.plusYears(1);
    }

    // COSTRUTTORE VUOTO PER JPA
    public Tessera(){
    }

    // LISTA METODI

    // GETTER/SETTER

    public UUID getId() {
        return id;
    }

    public LocalDate getDataDiEmissione() {
        return dataDiEmissione;
    }

    public void setDataDiEmissione(LocalDate dataDiEmissione) {
        this.dataDiEmissione = dataDiEmissione;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
}
