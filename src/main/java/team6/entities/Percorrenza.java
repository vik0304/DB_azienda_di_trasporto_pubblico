package team6.entities;

import java.time.LocalDate;
import java.math.BigInteger;

public class Percorrenza {
    public String id;
    public String idMezzo;
    public String idTratta;
    public LocalDate dataPartenza;
    public BigInteger durataCorsa;

    public Percorrenza(String id, String idMezzo, String idTratta, LocalDate dataPartenza, BigInteger durataCorsa) {
        this.id = id;
        this.idMezzo = idMezzo;
        this.idTratta = idTratta;
        this.dataPartenza = dataPartenza;
        this.durataCorsa = durataCorsa;
    }

    public String toString() {
        return "Percorrenza: " + id + " " + idMezzo + " " + idTratta + " " + dataPartenza + " " + durataCorsa;
    }
}