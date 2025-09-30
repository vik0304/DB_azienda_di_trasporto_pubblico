package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Abbonamento extends TitoloDiViaggio{
    @Column(name = "tipo_abbonamento")
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipoAbbonamento;
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Tessera idTessera;

    public Abbonamento(){
    }

    public Abbonamento(TipoAbbonamento tipoAbbonamento, Tessera idTessera, LocalDate dataAcquisto, Venditore venditore){
        super(dataAcquisto, venditore);
        this.tipoAbbonamento=tipoAbbonamento;
        if(tipoAbbonamento==TipoAbbonamento.MENSILE){
            this.dataScadenza = dataAcquisto.plusDays(30);
        }else if (tipoAbbonamento==TipoAbbonamento.SETTIMANALE){
            this.dataScadenza = dataAcquisto.plusDays(7);
        }
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
