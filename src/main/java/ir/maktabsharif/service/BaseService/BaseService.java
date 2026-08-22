package ir.maktabsharif.service.BaseService;

import ir.maktabsharif.model.BaseModel;

import java.util.List;

public interface BaseService <T extends BaseModel<ID>,ID extends Number>{

    T save(T t);

    T update(T t);

    T findByID(ID id);

    ID delete(ID id);

    List<T> findAll();
}
