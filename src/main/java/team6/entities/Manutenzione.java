package team6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Manutenzione {
    @Id
    private UUID id;

    @Column(name = "data_di_inizio")
    private LocalDate dataDiInizio;

    @Column(name = "data_di_fine")
    private LocalDate dataDiFine;

    // LISTA COSTRUTTORI
    public Manutenzione(LocalDate dataDiInizio, LocalDate dataDiFine){
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
    }

    // COSTRUTTORE VUOTO PER JPA
    public Manutenzione(){
    }

    // LISTA METODI

    // GETTER/SETTER
    public UUID getId() {
        return id;
    }

    public LocalDate getDataDiInizio() {
        return dataDiInizio;
    }

    public void setDataDiInizio(LocalDate dataDiInizio) {
        this.dataDiInizio = dataDiInizio;
    }

    public LocalDate getDataDiFine() {
        return dataDiFine;
    }

    public void setDataDiFine(LocalDate dataDiFine) {
        this.dataDiFine = dataDiFine;
    }
}
