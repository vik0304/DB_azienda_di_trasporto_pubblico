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

        mainMenu(ud, vd, tdv, td);

        s.close();
        em.close();
        emf.close();
    }

    public static void mainMenu(UtenteDAO ud, VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td) {
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
                        menuAdmin(vd, tdv, td);
                    } else if (userType.equals("USER")) {
                        menuUser();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("L'id inserito non è valido, verrai riportato all'inizio.");
                }
            }
        }
    }

    public static void menuAdmin(VeicoloDAO vd, TitoloDiViaggioDAO tdv, TesseraDAO td) {
        System.out.println("Benvenuto admin, seleziona l'operazione che vuoi eseguire oppure 0 per uscire.");
        int option;
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("1- Aggiungi un nuovo veicolo.");
            System.out.println("2- Verifica biglietti venduti in un periodo");
            System.out.println("3- Crea una nuova tessera");
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
                        vd.creaVeicoloDaInput(s);
                        break;
                    case 2:
                        tdv.trovaBigliettiPerData(s);
                        break;
                    case 3:
                        td.creaTesseraDaInput(s);
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
    }public static void menuUser() {
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
}
