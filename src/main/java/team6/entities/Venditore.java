package team6.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Venditore {
    @Id
    @GeneratedValue
    protected UUID id;
    protected String position;

    public Venditore(){}

    public Venditore(String position){
        this.position=position;
    }
}
