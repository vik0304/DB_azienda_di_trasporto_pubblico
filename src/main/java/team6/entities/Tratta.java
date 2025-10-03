package team6.entities;

import java.math.BigInteger;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public UUID id;

    @Column(name = "partenza")
    public String partenza;

    @Column(name = "capolinea")
    public String capolinea;

    @Column(name = "durata_prevista")
    public int durataPrevista;

    public Tratta() {}

    public Tratta(String partenza, String capolinea, int durataPrevista) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.durataPrevista = durataPrevista;
    }

    public String toString() {
        return "Tratta: " + id + " " + partenza + " " + capolinea + " " + durataPrevista;
    }

    public UUID getId() {
        return id;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public int getDurataPrevista() {
        return durataPrevista;
    }
}