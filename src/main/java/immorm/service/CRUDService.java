package immorm.service;

public interface CRUDService<T> {
    void save(T t);
    void update(T t);
    void deleteById(int id);
    T findById(int id);
}
