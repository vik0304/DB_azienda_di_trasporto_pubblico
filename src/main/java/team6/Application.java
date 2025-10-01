package team6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team6.dao.TitoloDiViaggioDAO;

import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbtrasporti");
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        TitoloDiViaggioDAO titoloDiViaggioDAO = new TitoloDiViaggioDAO(em);
        titoloDiViaggioDAO.trovaBigliettiPerData(s);

        s.close();
        em.close();
        emf.close();
    }
}
