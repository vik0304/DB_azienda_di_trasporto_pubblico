package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "titolo_di_viaggio")
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column(name = "data_acquisto")
    protected LocalDate dataAcquisto;
    @ManyToOne
    @JoinColumn(name="id_venditore", nullable = false)
    protected Venditore venditore;

    public TitoloDiViaggio(){};

    public TitoloDiViaggio(LocalDate dataAcquisto, Venditore venditore){
        this.dataAcquisto=dataAcquisto;
        this.venditore=venditore;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", dataAcquisto=" + dataAcquisto +
                ", venditore=" + venditore +
                '}';
    }
}
