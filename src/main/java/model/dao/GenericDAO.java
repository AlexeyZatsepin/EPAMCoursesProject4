package model.dao;

import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/3/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public interface GenericDAO<T> {
    T get(long id);
    long insert(T object);
    void update(T object);
    void delete(T object);
    List<T> getAll();
}
