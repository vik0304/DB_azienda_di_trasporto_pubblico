package team6.entities;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "veicolo")
public class Veicolo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @Column(name = "tipo_mezzo")
    public String tipoMezzo;

    @Column(name = "capienza")
    public int capienza;

    @Column(name = "in_manutenzione")
    public boolean inManutenzione;

    public Veicolo() {}

    public Veicolo(long id, String tipoMezzo, int capienza, boolean inManutenzione) {
        this.id = id;
        this.tipoMezzo = tipoMezzo;
        this.capienza = capienza;
        this.inManutenzione = inManutenzione;
    }

    public String toString() {
        return "Veicolo: " + id + " " + tipoMezzo + " " + capienza + " " + inManutenzione;
    }

    public long getId() {
        return id;
    }
}