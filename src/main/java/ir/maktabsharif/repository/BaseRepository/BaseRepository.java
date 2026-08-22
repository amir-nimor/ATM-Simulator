package ir.maktabsharif.repository.BaseRepository;

import ir.maktabsharif.model.BaseModel;

import java.util.List;

//crud   save   findByID   remove  update
//  findAll
public interface BaseRepository <T extends BaseModel<ID>,ID extends Number>{

    T create(T t);

    T findByID(ID id);

    ID remove(ID id);

    T update(T t);

    List<T> findAll();

}
