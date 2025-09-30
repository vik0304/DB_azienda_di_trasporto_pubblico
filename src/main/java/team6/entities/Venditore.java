package team6.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Venditore {
    @Id
    @GeneratedValue
    protected UUID id;
    protected String position;
//    @OneToMany(mappedBy = "venditore")
//    @Column(name = "lista_titoli_di_viaggio")
//    protected List<TitoloDiViaggio> listaTitoliDiViaggio = new ArrayList<>();

    public Venditore(){}

    public Venditore(String position){
        this.position=position;
    }

    public UUID getId() {
        return id;
    }
}
