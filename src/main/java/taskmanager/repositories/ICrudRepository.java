package taskmanager.repositories;

import java.util.List;

public interface ICrudRepository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
}