package ir.maktabsharif.util;

import jakarta.persistence.*;

import java.util.function.Function;

public class HibernateConnection {
    private static final String PERSISTENCE_UNIT = "ATM Simulator";

    private static EntityManagerFactory emf;

    private static EntityManagerFactory getEMF() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static EntityManager getEM() {
        EntityManager em = getEMF().createEntityManager();
        return em;
    }

    public static <T> T inTxReturne(Function<EntityManager, T> operation) {
        EntityManager em = getEM();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            T result = operation.apply(em);

            tx.commit();
            return result;
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new HibernateConnectionExcetion("Operation Failed!"+e.getMessage());
        } finally {
            em.close();
        }
    }
}
