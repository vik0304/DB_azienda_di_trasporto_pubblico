package team6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "distributore_automatico")
public class DistributoreAutomatico extends Venditore {
    @Column(name = "stato_attivazione")
    private boolean statoAttivazione;

    public DistributoreAutomatico(){}

    public DistributoreAutomatico(String posizione, boolean statoAttivazione){
        super(posizione);
        this.statoAttivazione=statoAttivazione;
    }
}
