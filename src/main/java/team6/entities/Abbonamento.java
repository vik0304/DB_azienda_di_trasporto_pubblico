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

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Tessera getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(Tessera idTessera) {
        this.idTessera = idTessera;
    }
}
