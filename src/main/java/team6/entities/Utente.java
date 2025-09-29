package team6.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Utente {
    private UUID codice_fiscale;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    // LISTA COSTRUTTORE
    public Utente(String nome, String cognome, LocalDate dataDiNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita=  dataDiNascita;
    }

    // COSTRUTTORE VUOTO
    public Utente(){
    }
}
