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
    public BigInteger durataPrevista;

    public Tratta() {}

    public Tratta(UUID id, String partenza, String capolinea, BigInteger durataPrevista) {
        this.id = id;
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
}