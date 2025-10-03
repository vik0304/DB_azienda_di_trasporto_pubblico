package team6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team6.dao.*;
import team6.entities.*;

import java.time.LocalDate;
import java.util.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbtrasporti");
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        System.out.println("Hello World!");
        ManutenzioneDAO md = new ManutenzioneDAO(em);
        PercorrenzaDAO pd = new PercorrenzaDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        TitoloDiViaggioDAO tdv = new TitoloDiViaggioDAO(em);
        TrattaDAO traD = new TrattaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        VeicoloDAO vd = new VeicoloDAO(em);
        VenditoreDAO venD = new VenditoreDAO(em);
        Utente u100 = new Utente("Viktor", "Vasileski", LocalDate.of(1998, 4, 3), TipoUtente.ADMIN);
        ud.save(u100);
//        Utente u1  = new Utente("Mario", "Rossi", LocalDate.of(1990, 5, 12), TipoUtente.USER);
//        Utente u2  = new Utente("Luca", "Bianchi", LocalDate.of(1985, 3, 8), TipoUtente.USER);
//        Utente u3  = new Utente("Giulia", "Verdi", LocalDate.of(1992, 11, 23), TipoUtente.USER);
//        Utente u4  = new Utente("Anna", "Neri", LocalDate.of(1988, 7, 2), TipoUtente.USER);
//        Utente u5  = new Utente("Francesco", "Russo", LocalDate.of(1995, 1, 15), TipoUtente.USER);
//        Utente u6  = new Utente("Chiara", "Romano", LocalDate.of(1991, 6, 30), TipoUtente.USER);
//        Utente u7  = new Utente("Alessandro", "Gallo", LocalDate.of(1987, 9, 5), TipoUtente.USER);
//        Utente u8  = new Utente("Valentina", "Ferrari", LocalDate.of(1993, 12, 18), TipoUtente.USER);
//        Utente u9  = new Utente("Davide", "Colombo", LocalDate.of(1989, 2, 10), TipoUtente.USER);
//        Utente u10 = new Utente("Sara", "Fontana", LocalDate.of(1994, 4, 27), TipoUtente.USER);
//        Utente u11 = new Utente("Matteo", "Serra", LocalDate.of(1986, 8, 19), TipoUtente.USER);
//        Utente u12 = new Utente("Elisa", "Moretti", LocalDate.of(1990, 10, 3), TipoUtente.USER);
//        Utente u13 = new Utente("Stefano", "Marino", LocalDate.of(1992, 5, 14), TipoUtente.USER);
//        Utente u14 = new Utente("Alessia", "Costa", LocalDate.of(1996, 7, 7), TipoUtente.USER);
//        Utente u15 = new Utente("Roberto", "Santoro", LocalDate.of(1984, 3, 25), TipoUtente.USER);
//        Utente u16 = new Utente("Ilaria", "Gentile", LocalDate.of(1991, 11, 9), TipoUtente.USER);
//        Utente u17 = new Utente("Paolo", "Martini", LocalDate.of(1993, 1, 20), TipoUtente.USER);
//        Utente u18 = new Utente("Federica", "Greco", LocalDate.of(1989, 12, 2), TipoUtente.USER);
//        Utente u19 = new Utente("Simone", "Lombardi", LocalDate.of(1995, 6, 13), TipoUtente.USER);
//        Utente u20 = new Utente("Silvia", "Villa", LocalDate.of(1987, 9, 29), TipoUtente.USER);
//        Utente u21 = new Utente("Giorgio", "De Luca", LocalDate.of(1992, 4, 1), TipoUtente.USER);
//        Utente u22 = new Utente("Martina", "Testa", LocalDate.of(1994, 2, 6), TipoUtente.USER);
//        Utente u23 = new Utente("Riccardo", "Ferri", LocalDate.of(1985, 5, 11), TipoUtente.USER);
//        Utente u24 = new Utente("Laura", "Giordano", LocalDate.of(1988, 7, 21), TipoUtente.USER);
//        Utente u25 = new Utente("Andrea", "Mancini", LocalDate.of(1990, 8, 15), TipoUtente.USER);
//        Utente u26 = new Utente("Francesca", "Caputo", LocalDate.of(1996, 1, 18), TipoUtente.USER);
//        Utente u27 = new Utente("Carlo", "Sartori", LocalDate.of(1991, 10, 24), TipoUtente.USER);
//        Utente u28 = new Utente("Angela", "Leone", LocalDate.of(1987, 6, 8), TipoUtente.USER);
//        Utente u29 = new Utente("Giovanni", "Barbieri", LocalDate.of(1993, 12, 30), TipoUtente.USER);
//        Utente u30 = new Utente("Beatrice", "Riva", LocalDate.of(1995, 9, 4), TipoUtente.USER);
//        Utente u31 = new Utente("Daniele", "Caruso", LocalDate.of(1986, 11, 27), TipoUtente.USER);
//        Utente u32 = new Utente("Lucia", "Fiore", LocalDate.of(1990, 3, 17), TipoUtente.USER);
//        Utente u33 = new Utente("Michele", "Orlando", LocalDate.of(1988, 7, 6), TipoUtente.USER);
//        Utente u34 = new Utente("Elena", "Monti", LocalDate.of(1992, 10, 12), TipoUtente.USER);
//        Utente u35 = new Utente("Pietro", "Silvestri", LocalDate.of(1991, 12, 5), TipoUtente.USER);
//        Utente u36 = new Utente("Alessandra", "Fabbri", LocalDate.of(1989, 4, 23), TipoUtente.USER);
//        Utente u37 = new Utente("Tommaso", "Caprioli", LocalDate.of(1994, 1, 9), TipoUtente.USER);
//        Utente u38 = new Utente("Marta", "Ruggiero", LocalDate.of(1987, 2, 14), TipoUtente.USER);
//        Utente u39 = new Utente("Nicola", "Parisi", LocalDate.of(1995, 8, 28), TipoUtente.USER);
//        Utente u40 = new Utente("Veronica", "Farina", LocalDate.of(1993, 6, 11), TipoUtente.USER);
//        Utente u41 = new Utente("Cristian", "Messina", LocalDate.of(1990, 9, 22), TipoUtente.USER);
//        Utente u42 = new Utente("Giada", "Amato", LocalDate.of(1992, 12, 17), TipoUtente.USER);
//        Utente u43 = new Utente("Fabio", "Palmieri", LocalDate.of(1986, 5, 4), TipoUtente.USER);
//        Utente u44 = new Utente("Serena", "De Angelis", LocalDate.of(1991, 7, 13), TipoUtente.USER);
//        Utente u45 = new Utente("Claudio", "Bernardi", LocalDate.of(1988, 10, 19), TipoUtente.USER);
//        Utente u46 = new Utente("Eleonora", "Basile", LocalDate.of(1995, 3, 21), TipoUtente.USER);
//        Utente u47 = new Utente("Samuele", "D’Amico", LocalDate.of(1993, 11, 8), TipoUtente.USER);
//        Utente u48 = new Utente("Camilla", "Longo", LocalDate.of(1994, 6, 2), TipoUtente.USER);
//        Utente u49 = new Utente("Enrico", "Marchetti", LocalDate.of(1990, 4, 25), TipoUtente.USER);
//        Utente u50 = new Utente("Alessio", "Conte", LocalDate.of(1989, 8, 30), TipoUtente.USER);
//
//
//
//        Veicolo v1  = new Veicolo("Autobus", 50, false);
//        Veicolo v2  = new Veicolo("Autobus", 60, false);
//        Veicolo v3  = new Veicolo("Autobus", 55, true);
//        Veicolo v4  = new Veicolo("Autobus", 70, false);
//        Veicolo v5  = new Veicolo("Autobus", 65, true);
//        Veicolo v6  = new Veicolo("Autobus", 75, false);
//        Veicolo v7  = new Veicolo("Autobus", 80, false);
//        Veicolo v8  = new Veicolo("Autobus", 45, true);
//        Veicolo v9  = new Veicolo("Autobus", 50, false);
//        Veicolo v10 = new Veicolo("Autobus", 60, false);
//        Veicolo v11 = new Veicolo("Autobus", 70, true);
//        Veicolo v12 = new Veicolo("Autobus", 55, false);
//        Veicolo v13 = new Veicolo("Autobus", 65, false);
//        Veicolo v14 = new Veicolo("Autobus", 75, true);
//        Veicolo v15 = new Veicolo("Autobus", 80, false);
//        Veicolo v16 = new Veicolo("Tram", 120, false);
//        Veicolo v17 = new Veicolo("Tram", 150, true);
//        Veicolo v18 = new Veicolo("Tram", 180, false);
//        Veicolo v19 = new Veicolo("Tram", 200, false);
//        Veicolo v20 = new Veicolo("Tram", 220, true);
//        Veicolo v21 = new Veicolo("Tram", 250, false);
//        Veicolo v22 = new Veicolo("Tram", 130, false);
//        Veicolo v23 = new Veicolo("Tram", 140, true);
//        Veicolo v24 = new Veicolo("Tram", 160, false);
//        Veicolo v25 = new Veicolo("Tram", 180, false);
//        Veicolo v26 = new Veicolo("Tram", 200, true);
//        Veicolo v27 = new Veicolo("Tram", 220, false);
//        Veicolo v28 = new Veicolo("Tram", 240, false);
//        Veicolo v29 = new Veicolo("Tram", 150, true);
//        Veicolo v30 = new Veicolo("Tram", 170, false);
//        Veicolo v31 = new Veicolo("Tram", 190, false);
//        Veicolo v32 = new Veicolo("Tram", 210, true);
//        Veicolo v33 = new Veicolo("Tram", 230, false);
//        Veicolo v34 = new Veicolo("Tram", 200, false);
//        Veicolo v35 = new Veicolo("Tram", 180, true);
//
//        Tratta t1  = new Tratta("Piazza Garibaldi", "Vomero", 35);
//        Tratta t2  = new Tratta("Chiaia", "Posillipo", 25);
//        Tratta t3  = new Tratta("Fuorigrotta", "Centro Direzionale", 40);
//        Tratta t4  = new Tratta("Secondigliano", "Piazza Garibaldi", 45);
//        Tratta t5  = new Tratta("Scampia", "Vomero", 50);
//        Tratta t6  = new Tratta("Sanità", "Mergellina", 30);
//        Tratta t7  = new Tratta("Arenella", "Chiaia", 35);
//        Tratta t8  = new Tratta("Vomero", "Fuorigrotta", 25);
//        Tratta t9  = new Tratta("Posillipo", "Centro Storico", 40);
//        Tratta t10 = new Tratta("Bagnoli", "Piazza Garibaldi", 50);
//        Tratta t11 = new Tratta("Ponticelli", "Secondigliano", 55);
//        Tratta t12 = new Tratta("Chiaiano", "Piazza Garibaldi", 45);
//        Tratta t13 = new Tratta("Miano", "Vomero", 35);
//        Tratta t14 = new Tratta("Poggioreale", "Centro Storico", 20);
//        Tratta t15 = new Tratta("San Giovanni a Teduccio", "Chiaia", 50);
//        Tratta t16 = new Tratta("Posillipo", "Fuorigrotta", 30);
//        Tratta t17 = new Tratta("Arenaccia", "Vomero", 25);
//
//        Percorrenza p1  = new Percorrenza(v1,  t1,  LocalDate.of(2025, 9, 24), 37);
//        Percorrenza p2  = new Percorrenza(v2,  t2,  LocalDate.of(2025, 9, 22), 52);
//        Percorrenza p3  = new Percorrenza(v3,  t3,  LocalDate.of(2025, 9, 29), 28);
//        Percorrenza p4  = new Percorrenza(v4,  t4,  LocalDate.of(2025, 9, 25), 42);
//        Percorrenza p5  = new Percorrenza(v5,  t5,  LocalDate.of(2025, 9, 30), 48);
//        Percorrenza p6  = new Percorrenza(v6,  t6,  LocalDate.of(2025, 9, 22), 33);
//        Percorrenza p7  = new Percorrenza(v7,  t7,  LocalDate.of(2025, 9, 26), 37);
//        Percorrenza p8  = new Percorrenza(v8,  t8,  LocalDate.of(2025, 10, 3), 27);
//        Percorrenza p9  = new Percorrenza(v9,  t9,  LocalDate.of(2025, 9, 29), 43);
//        Percorrenza p10 = new Percorrenza(v10, t10, LocalDate.of(2025, 9, 30), 55);
//        Percorrenza p11 = new Percorrenza(v11, t11, LocalDate.of(2025, 9, 24), 50);
//        Percorrenza p12 = new Percorrenza(v12, t12, LocalDate.of(2025, 9, 22), 40);
//        Percorrenza p13 = new Percorrenza(v13, t13, LocalDate.of(2025, 9, 29), 32);
//        Percorrenza p14 = new Percorrenza(v14, t14, LocalDate.of(2025, 9, 25), 22);
//        Percorrenza p15 = new Percorrenza(v15, t15, LocalDate.of(2025, 9, 30), 48);
//        Percorrenza p16 = new Percorrenza(v16, t16, LocalDate.of(2025, 9, 22), 125);
//        Percorrenza p17 = new Percorrenza(v17, t17, LocalDate.of(2025, 9, 26), 145);
//        Percorrenza p18 = new Percorrenza(v18, t1,  LocalDate.of(2025, 10, 3), 33);
//        Percorrenza p19 = new Percorrenza(v19, t2,  LocalDate.of(2025, 9, 29), 47);
//        Percorrenza p20 = new Percorrenza(v20, t3,  LocalDate.of(2025, 9, 30), 37);
//        Percorrenza p21 = new Percorrenza(v21, t4, LocalDate.of(2025, 9, 24), 45);
//        Percorrenza p22 = new Percorrenza(v22, t5, LocalDate.of(2025, 9, 22), 50);
//        Percorrenza p23 = new Percorrenza(v23, t6, LocalDate.of(2025, 9, 29), 30);
//        Percorrenza p24 = new Percorrenza(v24, t7, LocalDate.of(2025, 9, 25), 40);
//        Percorrenza p25 = new Percorrenza(v25, t8, LocalDate.of(2025, 9, 30), 27);
//        Percorrenza p26 = new Percorrenza(v26, t9, LocalDate.of(2025, 9, 22), 55);
//        Percorrenza p27 = new Percorrenza(v27, t10, LocalDate.of(2025, 9, 26), 53);
//        Percorrenza p28 = new Percorrenza(v28, t11, LocalDate.of(2025, 10, 3), 48);
//        Percorrenza p29 = new Percorrenza(v29, t12, LocalDate.of(2025, 9, 29), 42);
//        Percorrenza p30 = new Percorrenza(v30, t13, LocalDate.of(2025, 9, 30), 35);
//        Percorrenza p31 = new Percorrenza(v31, t14, LocalDate.of(2025, 9, 24), 20);
//        Percorrenza p32 = new Percorrenza(v32, t15, LocalDate.of(2025, 9, 22), 48);
//        Percorrenza p33 = new Percorrenza(v33, t16, LocalDate.of(2025, 9, 29), 135);
//        Percorrenza p34 = new Percorrenza(v34, t17, LocalDate.of(2025, 9, 25), 190);
//        Percorrenza p35 = new Percorrenza(v35, t1,  LocalDate.of(2025, 9, 30), 40);
//        Percorrenza p36 = new Percorrenza(v1,  t2,  LocalDate.of(2025, 9, 22), 52);
//        Percorrenza p37 = new Percorrenza(v2,  t3,  LocalDate.of(2025, 9, 26), 28);
//        Percorrenza p38 = new Percorrenza(v3,  t4,  LocalDate.of(2025, 10, 3), 43);
//        Percorrenza p39 = new Percorrenza(v4,  t5,  LocalDate.of(2025, 9, 29), 48);
//        Percorrenza p40 = new Percorrenza(v5,  t6,  LocalDate.of(2025, 9, 30), 33);
//        Percorrenza p41 = new Percorrenza(v6,  t7,  LocalDate.of(2025, 9, 24), 37);
//        Percorrenza p42 = new Percorrenza(v7,  t8,  LocalDate.of(2025, 9, 22), 27);
//        Percorrenza p43 = new Percorrenza(v8,  t9,  LocalDate.of(2025, 9, 29), 53);
//        Percorrenza p44 = new Percorrenza(v9,  t10, LocalDate.of(2025, 9, 25), 48);
//        Percorrenza p45 = new Percorrenza(v10, t11, LocalDate.of(2025, 9, 30), 42);
//        Percorrenza p46 = new Percorrenza(v11, t12, LocalDate.of(2025, 9, 22), 35);
//        Percorrenza p47 = new Percorrenza(v12, t13, LocalDate.of(2025, 9, 26), 20);
//        Percorrenza p48 = new Percorrenza(v13, t14, LocalDate.of(2025, 10, 3), 48);
//        Percorrenza p49 = new Percorrenza(v14, t15, LocalDate.of(2025, 9, 29), 50);
//        Percorrenza p50 = new Percorrenza(v15, t16, LocalDate.of(2025, 9, 30), 140);
//        Percorrenza p51 = new Percorrenza(v16, t17, LocalDate.of(2025, 9, 24), 195);
//        Percorrenza p52 = new Percorrenza(v17, t1,  LocalDate.of(2025, 9, 22), 37);
//        Percorrenza p53 = new Percorrenza(v18, t2,  LocalDate.of(2025, 9, 29), 52);
//        Percorrenza p54 = new Percorrenza(v19, t3,  LocalDate.of(2025, 9, 25), 28);
//        Percorrenza p55 = new Percorrenza(v20, t4,  LocalDate.of(2025, 9, 30), 43);
//        Percorrenza p56 = new Percorrenza(v21, t5,  LocalDate.of(2025, 9, 22), 48);
//        Percorrenza p57 = new Percorrenza(v22, t6,  LocalDate.of(2025, 9, 26), 33);
//        Percorrenza p58 = new Percorrenza(v23, t7,  LocalDate.of(2025, 10, 3), 37);
//        Percorrenza p59 = new Percorrenza(v24, t8,  LocalDate.of(2025, 9, 29), 27);
//        Percorrenza p60 = new Percorrenza(v25, t9,  LocalDate.of(2025, 9, 30), 53);
//        Percorrenza p61 = new Percorrenza(v26, t10, LocalDate.of(2025, 9, 24), 48);
//        Percorrenza p62 = new Percorrenza(v27, t11, LocalDate.of(2025, 9, 22), 42);
//        Percorrenza p63 = new Percorrenza(v28, t12, LocalDate.of(2025, 9, 29), 35);
//        Percorrenza p64 = new Percorrenza(v29, t13, LocalDate.of(2025, 9, 25), 20);
//        Percorrenza p65 = new Percorrenza(v30, t14, LocalDate.of(2025, 9, 30), 48);
//        Percorrenza p66 = new Percorrenza(v31, t15, LocalDate.of(2025, 9, 22), 50);
//        Percorrenza p67 = new Percorrenza(v32, t16, LocalDate.of(2025, 9, 26), 140);
//        Percorrenza p68 = new Percorrenza(v33, t17, LocalDate.of(2025, 10, 3), 195);
//        Percorrenza p69 = new Percorrenza(v34, t1,  LocalDate.of(2025, 9, 29), 37);
//        Percorrenza p70 = new Percorrenza(v35, t2,  LocalDate.of(2025, 9, 30), 52);
//        Percorrenza p71 = new Percorrenza(v1,  t3,  LocalDate.of(2025, 9, 24), 28);
//        Percorrenza p72 = new Percorrenza(v2,  t4,  LocalDate.of(2025, 9, 22), 43);
//        Percorrenza p73 = new Percorrenza(v3,  t5,  LocalDate.of(2025, 9, 29), 48);
//        Percorrenza p74 = new Percorrenza(v4,  t6,  LocalDate.of(2025, 9, 25), 33);
//        Percorrenza p75 = new Percorrenza(v5,  t7,  LocalDate.of(2025, 9, 30), 37);
//        Percorrenza p76 = new Percorrenza(v6,  t8,  LocalDate.of(2025, 9, 22), 27);
//        Percorrenza p77 = new Percorrenza(v7,  t9,  LocalDate.of(2025, 9, 26), 53);
//        Percorrenza p78 = new Percorrenza(v8,  t10, LocalDate.of(2025, 10, 3), 48);
//        Percorrenza p79 = new Percorrenza(v9,  t11, LocalDate.of(2025, 9, 29), 42);
//        Percorrenza p80 = new Percorrenza(v10, t12, LocalDate.of(2025, 9, 30), 35);
//        Percorrenza p81 = new Percorrenza(v11, t13, LocalDate.of(2025, 9, 24), 20);
//        Percorrenza p82 = new Percorrenza(v12, t14, LocalDate.of(2025, 9, 22), 48);
//        Percorrenza p83 = new Percorrenza(v13, t15, LocalDate.of(2025, 9, 29), 50);
//        Percorrenza p84 = new Percorrenza(v14, t16, LocalDate.of(2025, 9, 25), 140);
//        Percorrenza p85 = new Percorrenza(v15, t17, LocalDate.of(2025, 9, 30), 195);
//        Percorrenza p86 = new Percorrenza(v16, t1,  LocalDate.of(2025, 9, 22), 37);
//        Percorrenza p87 = new Percorrenza(v17, t2,  LocalDate.of(2025, 9, 26), 52);
//        Percorrenza p88 = new Percorrenza(v18, t3,  LocalDate.of(2025, 10, 3), 28);
//        Percorrenza p89 = new Percorrenza(v19, t4,  LocalDate.of(2025, 9, 29), 43);
//        Percorrenza p90 = new Percorrenza(v20, t5,  LocalDate.of(2025, 9, 30), 48);
//        Percorrenza p91 = new Percorrenza(v21, t6, LocalDate.of(2025, 9, 24), 33);
//        Percorrenza p92 = new Percorrenza(v22, t7, LocalDate.of(2025, 9, 22), 37);
//        Percorrenza p93 = new Percorrenza(v23, t8, LocalDate.of(2025, 9, 29), 27);
//        Percorrenza p94 = new Percorrenza(v24, t9, LocalDate.of(2025, 9, 25), 53);
//        Percorrenza p95 = new Percorrenza(v25, t10, LocalDate.of(2025, 9, 30), 48);
//        Percorrenza p96 = new Percorrenza(v26, t11, LocalDate.of(2025, 9, 22), 42);
//        Percorrenza p97 = new Percorrenza(v27, t12, LocalDate.of(2025, 9, 26), 35);
//        Percorrenza p98 = new Percorrenza(v28, t13, LocalDate.of(2025, 10, 3), 20);
//        Percorrenza p99 = new Percorrenza(v29, t14, LocalDate.of(2025, 9, 29), 48);
//        Percorrenza p100 = new Percorrenza(v30, t15, LocalDate.of(2025, 9, 30), 50);
//
//
//        Tessera te1  = new Tessera(LocalDate.of(2023, 5, 10), u1, Collections.emptyList());
//        Tessera te2  = new Tessera(LocalDate.of(2023, 3, 22), u2, Collections.emptyList());
//        Tessera te3  = new Tessera(LocalDate.of(2023, 6, 5),  u3, Collections.emptyList());
//        Tessera te4  = new Tessera(LocalDate.of(2023, 2, 17), u4, Collections.emptyList());
//        Tessera te5  = new Tessera(LocalDate.of(2023, 8, 1),  u5, Collections.emptyList());
//        Tessera te6  = new Tessera(LocalDate.of(2023, 4, 12), u6, Collections.emptyList());
//        Tessera te7  = new Tessera(LocalDate.of(2023, 1, 25), u7, Collections.emptyList());
//        Tessera te8  = new Tessera(LocalDate.of(2023, 9, 30), u8, Collections.emptyList());
//        Tessera te9  = new Tessera(LocalDate.of(2023, 5, 5),  u9, Collections.emptyList());
//        Tessera te10 = new Tessera(LocalDate.of(2023, 7, 18), u10, Collections.emptyList());
//        Tessera te11 = new Tessera(LocalDate.of(2023, 3, 3),  u11, Collections.emptyList());
//        Tessera te12 = new Tessera(LocalDate.of(2023, 6, 20), u12, Collections.emptyList());
//        Tessera te13 = new Tessera(LocalDate.of(2023, 2, 10), u13, Collections.emptyList());
//        Tessera te14 = new Tessera(LocalDate.of(2023, 8, 7),  u14, Collections.emptyList());
//        Tessera te15 = new Tessera(LocalDate.of(2023, 1, 15), u15, Collections.emptyList());
//        Tessera te16 = new Tessera(LocalDate.of(2024, 10, 5), u16, Collections.emptyList());
//        Tessera te17 = new Tessera(LocalDate.of(2024, 11, 12), u17, Collections.emptyList());
//        Tessera te18 = new Tessera(LocalDate.of(2024, 9, 20), u18, Collections.emptyList());
//        Tessera te19 = new Tessera(LocalDate.of(2024, 12, 1), u19, Collections.emptyList());
//        Tessera te20 = new Tessera(LocalDate.of(2024, 10, 15), u20, Collections.emptyList());
//        Tessera te21 = new Tessera(LocalDate.of(2024, 9, 25), u21, Collections.emptyList());
//        Tessera te22 = new Tessera(LocalDate.of(2024, 11, 5), u22, Collections.emptyList());
//        Tessera te23 = new Tessera(LocalDate.of(2024, 12, 10), u23, Collections.emptyList());
//        Tessera te24 = new Tessera(LocalDate.of(2024, 10, 28), u24, Collections.emptyList());
//        Tessera te25 = new Tessera(LocalDate.of(2024, 9, 30), u25, Collections.emptyList());
//        Tessera te26 = new Tessera(LocalDate.of(2024, 11, 18), u26, Collections.emptyList());
//        Tessera te27 = new Tessera(LocalDate.of(2024, 10, 2), u27, Collections.emptyList());
//        Tessera te28 = new Tessera(LocalDate.of(2024, 12, 7), u28, Collections.emptyList());
//        Tessera te29 = new Tessera(LocalDate.of(2024, 9, 29), u29, Collections.emptyList());
//        Tessera te30 = new Tessera(LocalDate.of(2024, 10, 20), u30, Collections.emptyList());
//        Tessera te31 = new Tessera(LocalDate.of(2024, 11, 1), u31, Collections.emptyList());
//        Tessera te32 = new Tessera(LocalDate.of(2024, 12, 15), u32, Collections.emptyList());
//        Tessera te33 = new Tessera(LocalDate.of(2024, 10, 5), u33, Collections.emptyList());
//        Tessera te34 = new Tessera(LocalDate.of(2024, 9, 27), u34, Collections.emptyList());
//        Tessera te35 = new Tessera(LocalDate.of(2024, 11, 10), u35, Collections.emptyList());
//        Tessera te36 = new Tessera(LocalDate.of(2024, 10, 8), u36, Collections.emptyList());
//        Tessera te37 = new Tessera(LocalDate.of(2024, 12, 3), u37, Collections.emptyList());
//        Tessera te38 = new Tessera(LocalDate.of(2024, 9, 29), u38, Collections.emptyList());
//        Tessera te39 = new Tessera(LocalDate.of(2024, 11, 14), u39, Collections.emptyList());
//        Tessera te40 = new Tessera(LocalDate.of(2024, 10, 12), u40, Collections.emptyList());
//        Tessera te41 = new Tessera(LocalDate.of(2024, 9, 30), u41, Collections.emptyList());
//        Tessera te42 = new Tessera(LocalDate.of(2024, 11, 18), u42, Collections.emptyList());
//        Tessera te43 = new Tessera(LocalDate.of(2024, 10, 3), u43, Collections.emptyList());
//        Tessera te44 = new Tessera(LocalDate.of(2024, 12, 7), u44, Collections.emptyList());
//        Tessera te45 = new Tessera(LocalDate.of(2024, 9, 26), u45, Collections.emptyList());
//        Tessera te46 = new Tessera(LocalDate.of(2024, 10, 20), u46, Collections.emptyList());
//        Tessera te47 = new Tessera(LocalDate.of(2024, 11, 1), u47, Collections.emptyList());
//        Tessera te48 = new Tessera(LocalDate.of(2024, 12, 15), u48, Collections.emptyList());
//        Tessera te49 = new Tessera(LocalDate.of(2024, 10, 5), u49, Collections.emptyList());
//        Tessera te50 = new Tessera(LocalDate.of(2024, 9, 27), u50, Collections.emptyList());
//
//        RivenditoreAutorizzato vend1 = new RivenditoreAutorizzato("Piazza Garibaldi, Napoli", "Rivendita Centrale");
//        DistributoreAutomatico   vend2 = new DistributoreAutomatico("Stazione Napoli Centrale", true);
//        RivenditoreAutorizzato vend3 = new RivenditoreAutorizzato("Via Toledo, Napoli", "Rivendita Toledo");
//
//        Abbonamento a1  = new Abbonamento(TipoAbbonamento.MENSILE, te1,  LocalDate.of(2024, 8, 5), vend1);
//        Abbonamento a2  = new Abbonamento(TipoAbbonamento.SETTIMANALE, te2, LocalDate.of(2024, 9, 1), vend2);
//        Abbonamento a3  = new Abbonamento(TipoAbbonamento.MENSILE, te3,  LocalDate.of(2024, 7, 20), vend3);
//        Abbonamento a4  = new Abbonamento(TipoAbbonamento.SETTIMANALE, te4, LocalDate.of(2024, 8, 12), vend1);
//        Abbonamento a5  = new Abbonamento(TipoAbbonamento.MENSILE, te5,  LocalDate.of(2024, 6, 30), vend2);
//        Abbonamento a6  = new Abbonamento(TipoAbbonamento.MENSILE, te16, LocalDate.of(2025, 9, 22), vend3);
//        Abbonamento a7  = new Abbonamento(TipoAbbonamento.SETTIMANALE, te17, LocalDate.of(2025, 9, 25), vend1);
//        Abbonamento a8  = new Abbonamento(TipoAbbonamento.MENSILE, te18, LocalDate.of(2025, 9, 28), vend2);
//        Abbonamento a9  = new Abbonamento(TipoAbbonamento.SETTIMANALE, te19, LocalDate.of(2025, 9, 29), vend3);
//        Abbonamento a10 = new Abbonamento(TipoAbbonamento.MENSILE, te20, LocalDate.of(2025, 9, 30), vend1);
//        Abbonamento a11 = new Abbonamento(TipoAbbonamento.SETTIMANALE, te21, LocalDate.of(2025, 10, 1), vend2);
//        Abbonamento a12 = new Abbonamento(TipoAbbonamento.MENSILE, te22, LocalDate.of(2025, 9, 24), vend3);
//        Abbonamento a13 = new Abbonamento(TipoAbbonamento.SETTIMANALE, te23, LocalDate.of(2025, 9, 26), vend1);
//        Abbonamento a14 = new Abbonamento(TipoAbbonamento.MENSILE, te24, LocalDate.of(2025, 9, 27), vend2);
//        Abbonamento a15 = new Abbonamento(TipoAbbonamento.SETTIMANALE, te25, LocalDate.of(2025, 9, 28), vend3);
//        Abbonamento a16 = new Abbonamento(TipoAbbonamento.MENSILE, te26, LocalDate.of(2025, 9, 29), vend1);
//        Abbonamento a17 = new Abbonamento(TipoAbbonamento.SETTIMANALE, te27, LocalDate.of(2025, 9, 30), vend2);
//        Abbonamento a18 = new Abbonamento(TipoAbbonamento.MENSILE, te28, LocalDate.of(2025, 10, 1), vend3);
//        Abbonamento a19 = new Abbonamento(TipoAbbonamento.SETTIMANALE, te29, LocalDate.of(2025, 10, 2), vend1);
//        Abbonamento a20 = new Abbonamento(TipoAbbonamento.MENSILE, te30, LocalDate.of(2025, 10, 3), vend2);
//
//        Biglietto b1  = new Biglietto(LocalDate.of(2025, 9, 22), vend1, false);
//        b1.setVeicolo(v1);
//        Biglietto b2  = new Biglietto(LocalDate.of(2025, 9, 22), vend2, true);
//        b2.setVeicolo(v2);
//        Biglietto b3  = new Biglietto(LocalDate.of(2025, 9, 23), vend3, false);
//        b3.setVeicolo(v3);
//        Biglietto b4  = new Biglietto(LocalDate.of(2025, 9, 23), vend1, true);
//        b4.setVeicolo(v4);
//        Biglietto b5  = new Biglietto(LocalDate.of(2025, 9, 24), vend2, false);
//        b5.setVeicolo(v5);
//        Biglietto b6  = new Biglietto(LocalDate.of(2025, 9, 24), vend3, true);
//        b6.setVeicolo(v6);
//        Biglietto b7  = new Biglietto(LocalDate.of(2025, 9, 25), vend1, false);
//        b7.setVeicolo(v7);
//        Biglietto b8  = new Biglietto(LocalDate.of(2025, 9, 25), vend2, true);
//        b8.setVeicolo(v8);
//        Biglietto b9  = new Biglietto(LocalDate.of(2025, 9, 26), vend3, false);
//        b9.setVeicolo(v9);
//        Biglietto b10 = new Biglietto(LocalDate.of(2025, 9, 26), vend1, true);
//        b10.setVeicolo(v10);
//
//        Manutenzione m1  = new Manutenzione(LocalDate.of(2025, 1, 5), LocalDate.of(2025, 1, 7), v1,  CauseManuntenzione.TAGLIANDO);
//        Manutenzione m2  = new Manutenzione(LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 12), v2,  CauseManuntenzione.FRENI);
//        Manutenzione m3  = new Manutenzione(LocalDate.of(2025, 3, 15), LocalDate.of(2025, 3, 17), v3,  CauseManuntenzione.MOTORE);
//        Manutenzione m4  = new Manutenzione(LocalDate.of(2025, 4, 5), LocalDate.of(2025, 4, 7), v4,  CauseManuntenzione.CAMBIO);
//        Manutenzione m5  = new Manutenzione(LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 3), v5,  CauseManuntenzione.GOMME);
//        Manutenzione m6  = new Manutenzione(LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 22), v6,  CauseManuntenzione.CRISTALLI);
//        Manutenzione m7  = new Manutenzione(LocalDate.of(2025, 6, 10), LocalDate.of(2025, 6, 12), v7,  CauseManuntenzione.GUASTI_VARI);
//        Manutenzione m8  = new Manutenzione(LocalDate.of(2025, 6, 25), LocalDate.of(2025, 6, 27), v8,  CauseManuntenzione.TAGLIANDO);
//        Manutenzione m9  = new Manutenzione(LocalDate.of(2025, 7, 5), LocalDate.of(2025, 7, 7), v9,  CauseManuntenzione.FRENI);
//        Manutenzione m10 = new Manutenzione(LocalDate.of(2025, 7, 20), LocalDate.of(2025, 7, 22), v10, CauseManuntenzione.MOTORE);
//        Manutenzione m11 = new Manutenzione(LocalDate.of(2025, 8, 1), LocalDate.of(2025, 8, 3), v11, CauseManuntenzione.CAMBIO);
//        Manutenzione m12 = new Manutenzione(LocalDate.of(2025, 8, 15), LocalDate.of(2025, 8, 17), v12, CauseManuntenzione.GOMME);
//        Manutenzione m13 = new Manutenzione(LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 3), v13, CauseManuntenzione.CRISTALLI);
//        Manutenzione m14 = new Manutenzione(LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 12), v14, CauseManuntenzione.GUASTI_VARI);
//        Manutenzione m15 = new Manutenzione(LocalDate.of(2025, 9, 20), LocalDate.of(2025, 9, 22), v15, CauseManuntenzione.TAGLIANDO);
//
//        // Utenti
//        List<Utente> utenti = Arrays.asList(
//                u1, u2, u3, u4, u5, u6, u7, u8, u9, u10,
//                u11, u12, u13, u14, u15, u16, u17, u18, u19, u20,
//                u21, u22, u23, u24, u25, u26, u27, u28, u29, u30,
//                u31, u32, u33, u34, u35, u36, u37, u38, u39, u40,
//                u41, u42, u43, u44, u45, u46, u47, u48, u49, u50
//        );
//        for (Utente u : utenti) {
//            ud.save(u);
//        }
//

//        List<Veicolo> veicoli = Arrays.asList(
//                v1, v2, v3, v4, v5, v6, v7, v8, v9, v10,
//                v11, v12, v13, v14, v15, v16, v17, v18, v19, v20,
//                v21, v22, v23, v24, v25, v26, v27, v28, v29, v30,
//                v31, v32, v33, v34, v35
//        );
//        for (Veicolo v : veicoli) {
//            vd.save(v);
//        }
//

//        List<Tratta> tratte = Arrays.asList(
//                t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
//                t11, t12, t13, t14, t15, t16, t17
//        );
//        for (Tratta t : tratte) {
//            traD.save(t);
//        }
//

//        List<Percorrenza> percorrenze = Arrays.asList(
//                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
//                p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
//                p21, p22, p23, p24, p25, p26, p27, p28, p29, p30,
//                p31, p32, p33, p34, p35, p36, p37, p38, p39, p40,
//                p41, p42, p43, p44, p45, p46, p47, p48, p49, p50,
//                p51, p52, p53, p54, p55, p56, p57, p58, p59, p60,
//                p61, p62, p63, p64, p65, p66, p67, p68, p69, p70,
//                p71, p72, p73, p74, p75, p76, p77, p78, p79, p80,
//                p81, p82, p83, p84, p85, p86, p87, p88, p89, p90,
//                p91, p92, p93, p94, p95, p96, p97, p98, p99, p100
//        );
//        for (Percorrenza p : percorrenze) {
//            pd.save(p);
//        }
//

//        List<Tessera> tessere = Arrays.asList(
//                te1, te2, te3, te4, te5, te6, te7, te8, te9, te10,
//                te11, te12, te13, te14, te15, te16, te17, te18, te19, te20,
//                te21, te22, te23, te24, te25, te26, te27, te28, te29, te30,
//                te31, te32, te33, te34, te35, te36, te37, te38, te39, te40,
//                te41, te42, te43, te44, te45, te46, te47, te48, te49, te50
//        );
//        for (Tessera te : tessere) {
//            td.save(te);
//        }
//

//        List<Venditore> venditori = Arrays.asList(vend1, vend2, vend3);
//        for (Venditore v : venditori) {
//            venD.save(v);
//        }
//

//        List<Abbonamento> abbonamenti = Arrays.asList(
//                a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
//                a11, a12, a13, a14, a15, a16, a17, a18, a19, a20
//        );
//        for (Abbonamento a : abbonamenti) {
//            tdv.save(a);
//        }
//

//        List<Biglietto> biglietti = Arrays.asList(
//                b1, b2, b3, b4, b5, b6, b7, b8, b9, b10
//        );
//        for (Biglietto b : biglietti) {
//            tdv.save(b);
//        }
//

//        List<Manutenzione> manutenzioni = Arrays.asList(
//                m1, m2, m3, m4, m5, m6, m7, m8, m9, m10,
//                m11, m12, m13, m14, m15
//        );
//        for (Manutenzione m : manutenzioni) {
//            md.save(m);
//        }

        mainMenu(ud, vd, tdv, td, traD, pd, md, venD);

        s.close();
        em.close();
        emf.close();
    }

    public static void mainMenu(UtenteDAO ud, VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, TrattaDAO traD, PercorrenzaDAO pd, ManutenzioneDAO md, VenditoreDAO venD) {
        boolean attivo = true;
        while (attivo) {
            System.out.println("Benvenuto, inserisci il tuo ID per iniziare ad utilizzare software oppure exit per uscire.");
            String input = s.nextLine();
            if (input.equals("exit")) {
                attivo = false;
                System.out.println("L'app verrà chiusa.");
            } else {
                try {
                    UUID utenteId = UUID.fromString(input);
                    TipoUtente userType = ud.userType(utenteId);
                    System.out.println("Avvio applicazione . . .");
                    if (userType == TipoUtente.ADMIN) {
                        menuAdmin(vd, tdv, td, traD, ud, pd, md, venD);
                    } else if (userType == TipoUtente.USER) {
                        menuUser(utenteId, traD, tdv);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("L'id inserito non è valido, verrai riportato all'inizio.");
                }
            }
        }
    }

    public static void menuAdmin(VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, TrattaDAO traD, UtenteDAO ud, PercorrenzaDAO pd, ManutenzioneDAO md, VenditoreDAO venD) {
        System.out.println("Benvenuto admin, seleziona l'operazione che vuoi eseguire oppure 0 per uscire.");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println(" MENU ADMIN ");
            System.out.println("1- Menu inserimento dati");
            System.out.println("2- Menu ricerca");
            System.out.println("3- Elimina dato");
            System.out.println("4- Numero percorrenze e tempo effettivo tratta");
            System.out.println("5- Biglietti e/o abbonamenti per periodo di tempo");
            System.out.println("6- Biglietti e/o abbonamenti per punto di vendita");
            System.out.println("7- Biglietti vidimati in un periodo di tempo");
            System.out.println("8- Biglietti vidimati su un determinato mezzo");
            System.out.println("9- Vidima biglietto");
            System.out.println("0- Esci");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        adminCreationMenu(vd, tdv, td, traD, ud, pd, md, venD);
                        break;
                    case 2:
                        menuAdminCerca(vd, tdv, td, traD, ud, pd, md, venD);
                        break;
                    case 3:
                        menuAdminElimina(vd, tdv, td, traD, ud, pd, md, venD);
                        break;
                    case 4:
                        System.out.println(" Numero Percorrenze ");
                        pd.cercaNumPercorrenzaDaInput(s);
                        System.out.println("\n Tempo Effettivo Tratta ");
                        pd.cercaTempoEffettivoTrattaDaInput(s);
                        break;
                    case 5:
                        tdv.trovaBigliettiPerData(s);
                        break;
                    case 6:
                        tdv.cercaTitoliPerPuntoVenditaDaInput(s);
                        break;
                    case 7:
                        tdv.cercaBigliettiVidimatiPerPeriodoDaInput(s);
                        break;
                    case 8:
                        tdv.cercaBigliettiVidimatiPerVeicoloDaInput(s);
                        break;
                    case 9:
                        tdv.vidimaBigliettoDaInput(s);
                        break;
                    default:
                        System.out.println("Opzione non valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void adminCreationMenu(VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, TrattaDAO traD, UtenteDAO ud, PercorrenzaDAO pd, ManutenzioneDAO md, VenditoreDAO venD){
        System.out.println("Seleziona l'elemento che vuoi inserire");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- Biglietto/Abbonamento");
            System.out.println("2- Utente");
            System.out.println("3- Tessera");
            System.out.println("4- Veicolo");
            System.out.println("5- Manutenzione");
            System.out.println("6- Tratta");
            System.out.println("7- Percorrenza");
            System.out.println("8- Rivenditore autorizzato / Distributore automatico");
            System.out.println("0-  Torna indietro");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                    tdv.creaTitoloDiViaggioDaInput(s);
                        break;
                    case 2:
                    ud.createUtente(s);
                        break;
                    case 3:
                    td.creaTesseraDaInput(s);
                        break;
                    case 4:
                    vd.creaVeicoloDaInput(s);
                        break;
                    case 5:
                    md.createManutenzione(s, vd);
                        break;
                    case 6:
                    traD.trattaCreate(s);
                        break;
                    case 7:
                    pd.percorrenzaCreate(s, traD, vd);
                        break;
                    case 8:
                    venD.createVenditore(s);
                        break;
                    default:
                        System.out.println("Opzione non valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void menuAdminCerca(VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, TrattaDAO traD, UtenteDAO ud, PercorrenzaDAO pd, ManutenzioneDAO md, VenditoreDAO venD) {
        System.out.println(" Seleziona quale elemento vuoi cercare in base all'id: ");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- Biglietto/Abbonamento");
            System.out.println("2- Utente");
            System.out.println("3- Tessera");
            System.out.println("4- Veicolo");
            System.out.println("5- Manutenzione");
            System.out.println("6- Tratta");
            System.out.println("7- Percorrenza");
            System.out.println("8- Rivenditore autorizzato / Distributore automatico");
            System.out.println("0-  Torna indietro");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        tdv.cerca(s);
                        break;
                    case 2:
                        ud.cercaUtentePerIdDaInput(s);
                        break;
                    case 3:
                        td.cercaTesseraPerIdDaInput(s);
                        break;
                    case 4:
                        vd.cercaVeicoloPerIdDaInput(s);
                        break;
                    case 5:
                        md.cerca(s);
                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    default:
                        System.out.println("Opzione non valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void menuAdminElimina(VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, TrattaDAO traD, UtenteDAO ud, PercorrenzaDAO pd, ManutenzioneDAO md, VenditoreDAO venD) {
        System.out.println(" Seleziona quale elemento vuoi eliminare in base all'id: ");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- Biglietto/Abbonamento");
            System.out.println("2- Utente");
            System.out.println("3- Tessera");
            System.out.println("4- Veicolo");
            System.out.println("5- Manutenzione");
            System.out.println("6- Tratta");
            System.out.println("7- Percorrenza");
            System.out.println("8- Rivenditore autorizzato / Distributore automatico");
            System.out.println("0-  Torna indietro");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        tdv.elimina(s);
                        break;
                    case 2:
                        ud.elimina(s);
                        break;
                    case 3:
                        td.elimina(s);
                        break;
                    case 4:
                        vd.elimina(s);
                        break;
                    case 5:
                        md.elimina(s);
                        break;
                    case 6:
                        traD.elimina(s);
                        break;
                    case 7:
                        pd.elimina(s);
                        break;
                    case 8:
                        venD.elimina(s);
                        break;
                    default:
                        System.out.println("Opzione non valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void menuUser(UUID utenteId, TrattaDAO traD, TitoloDiViaggioDAO tdv) {
        System.out.println("Benvenuto, seleziona l'operazione che vuoi eseguire oppure 0 per uscire.");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- ");
            System.out.println("2- Verifica stato abbonamento");
            System.out.println("3- Visualizza lista tratte disponibili");
            System.out.println("4- ");
            System.out.println("5- ");
            System.out.println("6- ");
            System.out.println("7- ");
            System.out.println("8- ");
            System.out.println("0-  ");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:

                        break;
                    case 2:
                        tdv.verificaStatoAbbonamento(utenteId);
                        break;
                    case 3:
                        traD.mostraListaTratte(utenteId);
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    default:
                        System.out.println("Opzione non valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }
}
