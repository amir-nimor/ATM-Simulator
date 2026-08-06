package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.exception.UserNotFoundException;
import ir.maktabsharif.model.User;
import ir.maktabsharif.util.HibernateConnection;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserGenericRepository {

    @Override
    public Optional<User> create(User user) {
        return Optional.ofNullable(HibernateConnection.inTxReturne(em -> {
            em.persist(user);
            return user;
        }));
    }

    @Override
    public Optional<User> findByID(Long aLong) {
        return Optional.ofNullable(HibernateConnection.inTxReturne(em -> {
            User user = em.find(User.class, aLong);
            if (user != null) {
                return user;
            }
            throw new UserNotFoundException("User is null");
        }));
    }

    @Override
    public Long remove(Long aLong) {
        return HibernateConnection.inTxReturne(em -> {
            User user = em.find(User.class, aLong);
            if (user != null) {
                em.remove(user);
                return user.getId();
            }
            throw new UserNotFoundException("User " + aLong + " not founded");
        });
    }

    @Override
    public Optional<User> update(User user) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return HibernateConnection.inTxReturne(em -> {
            return em.createQuery("FROM User ", User.class).getResultList();
        });
    }
}
