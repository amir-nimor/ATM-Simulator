package ir.maktabsharif.repository;

import ir.maktabsharif.model.BaseModel;

import java.util.List;
import java.util.Optional;

//crud   save   findByID   remove  update
//  findAll
public interface GenericRepository <T extends BaseModel<ID>,ID>{

    Optional<T> create(T t);

    Optional<T> findByID(ID id);

    ID remove(ID id);

    Optional<T> update(T t);

    List<T> findAll();

}
