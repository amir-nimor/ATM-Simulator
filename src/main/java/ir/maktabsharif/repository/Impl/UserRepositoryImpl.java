package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
