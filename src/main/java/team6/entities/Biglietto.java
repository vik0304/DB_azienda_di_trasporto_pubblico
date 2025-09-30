package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto extends TitoloDiViaggio {
    private boolean validato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veicolo_id")
    private Veicolo veicolo;

    public Biglietto(){};

    public Biglietto(LocalDate dataAcquisto, Venditore venditore, boolean validato){
        super(dataAcquisto, venditore);
        this.validato=validato;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
}
