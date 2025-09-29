package team6.entities;

import java.util.UUID;

public class Veicolo {
    public UUID id;
    public String tipoMezzo;
    public int capienza;
    public boolean inManutenzione;

    public Veicolo() {}

    public Veicolo(UUID id, String tipoMezzo, int capienza, boolean inManutenzione) {
        this.id = id;
        this.tipoMezzo = tipoMezzo;
        this.capienza = capienza;
        this.inManutenzione = inManutenzione;
    }

    public String toString() {
        return "Veicolo: " + id + " " + tipoMezzo + " " + capienza + " " + inManutenzione;
    }

    public UUID getId() {
        return id;
    }
}