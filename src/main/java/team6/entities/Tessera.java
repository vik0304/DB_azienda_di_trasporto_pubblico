package team6.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Tessera {
    private UUID id;
    private LocalDate dataDiEmissione;

    // LISTA COSTRUTTORE
    public Tessera(LocalDate dataDiEmissione){
        this.dataDiEmissione=dataDiEmissione;
    }

    // COSTRUTTORE VUOTO
    public Tessera(){
    }
}
