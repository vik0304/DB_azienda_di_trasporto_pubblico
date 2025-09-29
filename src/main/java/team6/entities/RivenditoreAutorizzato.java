package team6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rivenditore_autorizzato")
public class RivenditoreAutorizzato extends Venditore {
    private String nome;

    public RivenditoreAutorizzato(){}

    public RivenditoreAutorizzato(String posizione, String nome){
        super(posizione);
        this.nome=nome;
    }
}
