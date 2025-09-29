package team6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Distributore_Automatico extends Venditore {
    @Column(name = "stato_attivazione")
    private boolean statoAttivazione;

    public Distributore_Automatico(){}

    public Distributore_Automatico(String posizione, boolean statoAttivazione){
        super(posizione);
        this.statoAttivazione=statoAttivazione;
    }
}
