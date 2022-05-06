package immorm.service;

public interface CRUDService<T> {
//    void find(T t);
    void save(T t);
    void update(T t);
    void deleteById(int id);
}
