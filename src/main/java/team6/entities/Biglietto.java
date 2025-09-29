package team6.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Biglietto extends TitoloDiViaggio {
    private boolean validato;

    public Biglietto(){};

    public Biglietto(LocalDate dataAcquisto, boolean validato){
        super(dataAcquisto);
        this.validato=validato;
    }
}
