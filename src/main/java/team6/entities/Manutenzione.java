package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Manutenzione {
    @Id
    @GeneratedValue
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
    public Manutenzione(LocalDate dataDiInizio, LocalDate dataDiFine, Veicolo veicolo, CauseManuntenzione causeManuntenzione){
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

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", dataDiInizio=" + dataDiInizio +
                ", dataDiFine=" + dataDiFine +
                ", causeManuntenzione=" + causeManuntenzione +
                ", veicolo=" + veicolo +
                '}';
    }
}
