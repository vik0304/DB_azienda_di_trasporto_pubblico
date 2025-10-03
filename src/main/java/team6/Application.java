package team6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team6.dao.*;

import java.util.Scanner;
import java.util.UUID;

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
                    String userType = ud.userType(utenteId);
                    System.out.println("Avvio applicazione . . .");
                    if (userType.equals("ADMIN")) {
                        menuAdmin(vd, tdv, td, traD, ud, pd, md, venD);
                    } else if (userType.equals("USER")) {
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
