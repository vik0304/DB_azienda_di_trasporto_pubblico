package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "codice_fiscale")
    private UUID codiceFiscale;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    private TipoUtente tipoUtente;

    // LISTA COSTRUTTORE
    public Utente(String nome, String cognome, LocalDate dataDiNascita, TipoUtente tipoUtente){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita =  dataDiNascita;
        this.tipoUtente = tipoUtente;
    }

    // COSTRUTTORE VUOTO PER JPA
    public Utente(){
    }

    // LISTA METODI

    // GETTER/SETTER

    public UUID getCodice_fiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public TipoUtente getTipoUtente() {
        return tipoUtente;
    }
}
