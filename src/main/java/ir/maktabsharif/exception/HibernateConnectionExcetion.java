package ir.maktabsharif.exception;

public class HibernateConnectionExcetion extends RuntimeException {
    public HibernateConnectionExcetion(String message) {
        super(message);
    }
}
