package team6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Utente {
    @Id
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

    @OneToMany(mappedBy = "idUtente")
    private List<Tessera> tessere;

    // LISTA COSTRUTTORE
    public Utente(String nome, String cognome, LocalDate dataDiNascita, List<Tessera> tessere, TipoUtente tipoUtente){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita =  dataDiNascita;
        this.tessere = tessere;
        this.tipoUtente = tipoUtente;
    }

    // COSTRUTTORE VUOTO PER JPA
    public Utente(){
    }

    // LISTA METODI

    // GETTER/SETTER

    public UUID getCodice_fiscale() {
        return codice_fiscale;
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

    public List<Tessera> getTessere() {
        return tessere;
    }

    public void setTessere(List<Tessera> tessere) {
        this.tessere = tessere;
    }
}
