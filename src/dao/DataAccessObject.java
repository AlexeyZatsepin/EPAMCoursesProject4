package dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public abstract class DataAccessObject<T> {
    private final static Logger log = Logger.getLogger(DataAccessObject.class);
    protected Session session;
    private final Class<T> type;

    public DataAccessObject(Session session, Class<T> type) {
        this.session = session;
        this.type = type;
    }

    public T get(long id){
        try {
            session.beginTransaction();
            T client = (T) session.get(type,id);

            session.getTransaction().commit();
            return client;
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            return null;
        }
    }


    public long insert(T object){
        try{
            session.beginTransaction();
            long id =  (Long) session.save(object);
            session.getTransaction().commit();
            log.info(object + " inserted");
            return id;
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            log.error(e);
        }
        return -1;
    }

    public void update(T object){
        try{
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            log.info(object + " updated");
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            log.error(e);
        }
    }

    public void delete(T object){
        try{
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            log.info(object + " deleted");
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            log.error(e);
        }
    }
}
