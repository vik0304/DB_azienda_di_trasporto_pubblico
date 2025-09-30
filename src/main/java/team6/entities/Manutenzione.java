package team6.entities;

import jakarta.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private CauseManuntenzione causeManuntenzione;


    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Veicolo veicolo;

    // LISTA COSTRUTTORI
    public Manutenzione(LocalDate dataDiInizio, LocalDate dataDiFine, CauseManuntenzione causeManuntenzione){
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
    }

    public Manutenzione(LocalDate dataDiInizio, LocalDate dataDiFine, Veicolo veicolo){
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
        this.veicolo = veicolo;
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

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
}
