package team6.entities;

import java.time.LocalDate;
import java.math.BigInteger;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "percorrenza")
public class Percorrenza {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public UUID id;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    public Veicolo veicolo;

    @ManyToOne
    @JoinColumn(name = "id_tratta")
    public Tratta tratta;

    @Column(name = "data_di_partenza")
    public LocalDate dataPartenza;

    @Column(name = "durata_corsa")
    public BigInteger durataCorsa;

    public Percorrenza() {}

    public Percorrenza(UUID id, Veicolo veicolo, Tratta tratta, LocalDate dataPartenza, BigInteger durataCorsa) {
        this.id = id;
        this.veicolo = veicolo;
        this.tratta = tratta;
        this.dataPartenza = dataPartenza;
        this.durataCorsa = durataCorsa;
    }

    public String toString() {
        return "Percorrenza: " + id + " " + veicolo.getId() + " " + tratta.getId() + " " + dataPartenza + " " + durataCorsa;
    }

    public UUID getId() {
        return id;
    }
}