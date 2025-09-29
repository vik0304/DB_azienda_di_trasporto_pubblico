package team6.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Manutenzione {
    private UUID id;
    private LocalDate dataDiInizio;
    private LocalDate dataDiFine;

    // LISTA COSTRUTTORI
    public Manutenzione(LocalDate dataDiInizio, LocalDate dataDiFine){
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
    }

    // COSTRUTTORE VUOTO
    public Manutenzione(){
    }
}
