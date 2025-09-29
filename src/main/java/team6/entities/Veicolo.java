package team6.entities;

public class Veicolo {
    public String id;
    public String tipoMezzo;
    public int capienza;
    public boolean inManutenzione;

    public Veicolo(String id, String tipoMezzo, int capienza, boolean inManutenzione) {
        this.id = id;
        this.tipoMezzo = tipoMezzo;
        this.capienza = capienza;
        this.inManutenzione = inManutenzione;
    }

    public String toString() {
        return "Veicolo: " + id + " " + tipoMezzo + " " + capienza + " " + inManutenzione;
    }
}