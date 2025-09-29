package team6.entities;

import java.math.BigInteger;
import java.util.UUID;

public class Tratta {
    public UUID id;
    public String partenza;
    public String capolinea;
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