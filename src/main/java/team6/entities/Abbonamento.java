package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Abbonamento extends TitoloDiViaggio{
    @Id
    @GeneratedValue
    @Column(name = "id_abbonamento")
    private UUID idAbbonamento;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Tessera idTessera;

    public Abbonamento(){
    }

    public Abbonamento(LocalDate dataEmissione, Tessera idTessera, LocalDate dataAcquisto, Venditore venditore){
        super(dataAcquisto, venditore);
        this.dataEmissione = dataEmissione;
        this.idTessera = idTessera;
    }

//    public UUID getNumeroTessera() {
//        return idAbbonamento;
//    }
//
//    public LocalDate getDataAcquisto() {
//        return dataAcquisto;
//    }
//
//    public void setDataAcquisto(LocalDate dataAcquisto) {
//        this.dataAcquisto = dataAcquisto;
//    }
//
//    public LocalDate getDataEmissione() {
//        return dataEmissione;
//    }
//
//    public void setDataEmissione(LocalDate dataEmissione) {
//        this.dataEmissione = dataEmissione;
//    }
//
//    public Tessera getIdTessera() {
//        return idTessera;
//    }
//
//    public void setIdTessera(Tessera idTessera) {
//        this.idTessera = idTessera;
//    }
}
