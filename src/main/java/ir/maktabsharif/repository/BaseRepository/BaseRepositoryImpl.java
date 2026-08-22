package ir.maktabsharif.repository.BaseRepository;

import ir.maktabsharif.exception.OperationExceptionFailed;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.util.HibernateConnection;

import java.util.List;


public class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Number>
        implements BaseRepository<T, ID> {

    private final Class<T> entityType;

    public BaseRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public T create(T t) {
        try {
            return HibernateConnection.inTxReturne(em -> {
                em.persist(t);
                return t;
            });
        } catch (RuntimeException e) {
            throw new OperationExceptionFailed("operation save is failed => " + e);
        }
    }

    @Override
    public T findByID(ID id) {
        try {
            return HibernateConnection.getEM().find(entityType, id);
        } catch (RuntimeException e) {
            throw new OperationExceptionFailed("operation find is failed => " + e);
        }
    }

    @Override
    public ID remove(ID id) {

        try {
            return HibernateConnection.inTxReturne(em -> {
                em.remove(em.find(entityType, id));
                return id;
            });
        } catch (RuntimeException e) {
            throw new OperationExceptionFailed("operation remove is failed => " + e);
        }
    }

    @Override
    public T update(T t) {
        try {
            return HibernateConnection.inTxReturne(em -> {
            em.merge(t);
            return t;
            });
        } catch (RuntimeException e) {
            throw new OperationExceptionFailed("operation update is failed => " + e);
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return HibernateConnection.getEM().createQuery("SELECT u FROM User u").getResultList();
        } catch (RuntimeException e) {
            throw new OperationExceptionFailed("operation find all is failed => " + e);
        }
    }
}
