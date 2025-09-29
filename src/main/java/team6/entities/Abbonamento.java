package team6.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Abbonamento {
    private UUID numeroTessera;
    private LocalDate dataAcquisto;
    private LocalDate dataEmissione;

    // LISTA COSTRUTTORI
    public Abbonamento(LocalDate dataAcquisto, LocalDate dataEmissione){
        this.dataAcquisto = dataAcquisto;
        this.dataEmissione = dataEmissione;
    }

    // COSTRUTTORE VUOTO
    public Abbonamento(){
    }

}
