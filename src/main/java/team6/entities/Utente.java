package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Utente {
    @Id
    private UUID codice_fiscale;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @OneToMany(mappedBy = "utente")
    private List<Tessera> tessere;

    // LISTA COSTRUTTORE
    public Utente(String nome, String cognome, LocalDate dataDiNascita, List<Tessera> tessere){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita =  dataDiNascita;
        this.tessere = tessere;
    }

    // COSTRUTTORE VUOTO PER JPA
    public Utente(){
    }
}
