package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Abbonamento {
    @Id
    private UUID numeroTessera;

    @Column(name = "data_accquiesto")
    private LocalDate dataAcquisto;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Tessera idTessera;

    // LISTA COSTRUTTORI
    public Abbonamento(LocalDate dataAcquisto, LocalDate dataEmissione, Tessera idTessera){
        this.dataAcquisto = dataAcquisto;
        this.dataEmissione = dataEmissione;
        this.idTessera = idTessera;
    }

    // COSTRUTTORE VUOTO PER JPA
    public Abbonamento(){
    }

    // LISTA METODI

    // GETTER/SETTER
    public UUID getNumeroTessera() {
        return numeroTessera;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Tessera getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(Tessera idTessera) {
        this.idTessera = idTessera;
    }
}
