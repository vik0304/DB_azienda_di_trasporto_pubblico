package team6.entities;

import java.math.BigInteger;

public class Tratta {
    public String id;
    public String partenza;
    public String capolinea;
    public BigInteger durataPrevista;

    public Tratta() {}

    public Tratta(String id, String partenza, String capolinea, BigInteger durataPrevista) {
        this.id = id;
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.durataPrevista = durataPrevista;
    }

    public String toString() {
        return "Tratta: " + id + " " + partenza + " " + capolinea + " " + durataPrevista;
    }
}