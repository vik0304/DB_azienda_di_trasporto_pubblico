package team6.entities;

import java.time.LocalDate;
import java.math.BigInteger;
import java.util.UUID;

public class Percorrenza {
    public UUID id;
    public String idMezzo;
    public String idTratta;
    public LocalDate dataPartenza;
    public BigInteger durataCorsa;

    public Percorrenza() {}

    public Percorrenza(UUID id, String idMezzo, String idTratta, LocalDate dataPartenza, BigInteger durataCorsa) {
        this.id = id;
        this.idMezzo = idMezzo;
        this.idTratta = idTratta;
        this.dataPartenza = dataPartenza;
        this.durataCorsa = durataCorsa;
    }

    public String toString() {
        return "Percorrenza: " + id + " " + idMezzo + " " + idTratta + " " + dataPartenza + " " + durataCorsa;
    }

    public UUID getId() {
        return id;
    }
}