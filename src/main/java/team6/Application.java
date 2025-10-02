package team6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team6.dao.TesseraDAO;
import team6.dao.TitoloDiViaggioDAO;
import team6.dao.UtenteDAO;
import team6.dao.VeicoloDAO;

import java.util.Scanner;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbtrasporti");
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        TitoloDiViaggioDAO tdv = new TitoloDiViaggioDAO(em);
        System.out.println("Hello World!");
        UtenteDAO ud = new UtenteDAO(em);
        VeicoloDAO vd = new VeicoloDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        team6.dao.PercorrenzaDAO pd = new team6.dao.PercorrenzaDAO(em);

        mainMenu(ud, vd, tdv, td, pd);

        s.close();
        em.close();
        emf.close();
    }

    public static void mainMenu(UtenteDAO ud, VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, team6.dao.PercorrenzaDAO pd) {
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
                        menuAdmin(vd, tdv, td, ud, pd);
                    } else if (userType.equals("USER")) {
                        menuUser();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("L'id inserito non è valido, verrai riportato all'inizio.");
                }
            }
        }
    }

    public static void menuAdmin(VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td, UtenteDAO ud, team6.dao.PercorrenzaDAO pd) {
        System.out.println("Benvenuto admin, seleziona l'operazione che vuoi eseguire oppure 0 per uscire.");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("=== MENU ADMIN ===");
            System.out.println("1- Menu inserimento dati");
            System.out.println("2- Menu ricerca");
            System.out.println("3- Vidima biglietto");
            System.out.println("4- Numero percorrenze e tempo effettivo tratta");
            System.out.println("5- Biglietti e/o abbonamenti per periodo di tempo");
            System.out.println("6- Biglietti e/o abbonamenti per punto di vendita");
            System.out.println("7- Biglietti vidimati in un periodo di tempo");
            System.out.println("8- Biglietti vidimati su un determinato mezzo");
            System.out.println("0- Esci");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:

                        break;
                    case 2:
                        menuAdminCerca(tdv, vd, td, ud);
                        break;
                    case 3:
                        tdv.vidimaBigliettoDaInput(s);
                        break;
                    case 4:
                        System.out.println("--- Numero Percorrenze ---");
                        pd.cercaNumPercorrenzaDaInput(s);
                        System.out.println("\n--- Tempo Effettivo Tratta ---");
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
                    default:
                        System.out.println("Opzione non valida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void adminCreationMenu(){
        System.out.println("Seleziona l'elemento che vuoi inserire");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- Biglietto");
            System.out.println("2- Abbonamento");
            System.out.println("3- Utente");
            System.out.println("4- Tessera");
            System.out.println("5- Veicolo");
            System.out.println("6- Manutenzione");
            System.out.println("7- Tratta");
            System.out.println("8- Percorrenza");
            System.out.println("9- Rivenditore autorizzato");
            System.out.println("10- Distributore automatico");
            System.out.println("0-  Torna indietro");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

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
                    case 9:

                        break;
                    case 10:

                        break;
                    default:
                        isWorking = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void menuUser() {
        System.out.println("Benvenuto, seleziona l'operazione che vuoi eseguire oppure 0 per uscire.");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- ");
            System.out.println("2- ");
            System.out.println("3- ");
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

                        break;
                    case 3:

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
                        isWorking = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero intero positivo.");
            }
        }
    }

    public static void menuAdminCerca(TitoloDiViaggioDAO tdv, VeicoloDAO vd, TesseraDAO td, UtenteDAO ud) {
        System.out.println(" MENU CERCA ADMIN ");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- Cerca vendite titoli di viaggio per periodo");
            System.out.println("2- Cerca biglietti validati per veicolo");
            System.out.println("3- Cerca biglietti validati per periodo");
            System.out.println("4- Cerca abbonamenti attivi per tessera");
            System.out.println("5- Cerca utente per ID");
            System.out.println("6- Cerca veicolo per ID");
            System.out.println("7- Cerca tessera per ID");
            System.out.println("0- Torna indietro");
            try {
                option = Integer.parseInt(s.nextLine());
                switch (option) {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        tdv.trovaBigliettiPerData(s);
                        break;
                    case 2:
                        tdv.cercaBigliettiVidimatiPerVeicoloDaInput(s);
                        break;
                    case 3:
                        tdv.cercaBigliettiVidimatiPerPeriodoDaInput(s);
                        break;
                    case 4:
                        td.cercaAbbonamentiAttiviPerTesseraDaInput(s);
                        break;
                    case 5:
                        ud.cercaUtentePerIdDaInput(s);
                        break;
                    case 6:
                        vd.cercaVeicoloPerIdDaInput(s);
                        break;
                    case 7:
                        td.cercaTesseraPerIdDaInput(s);
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
