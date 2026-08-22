package ir.maktabsharif.service.BaseService;

import ir.maktabsharif.exception.OperationExceptionFailed;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;

import java.util.List;

public class BaseServiceImpl<T extends BaseModel<ID>,
        ID extends Number,
        R extends BaseRepository<T,ID>>
        implements BaseService<T,ID>{

    private R repository;


    public BaseServiceImpl(R repository){
        this.repository = repository;
    }


    @Override
    public T save(T t) {
        try {
            return repository.create(t);
        }catch (OperationExceptionFailed e){
            System.out.println("save operation failed "+e.getMessage());
        }

    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T findByID(ID id) {
        return null;
    }

    @Override
    public ID delete(ID id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }
}
