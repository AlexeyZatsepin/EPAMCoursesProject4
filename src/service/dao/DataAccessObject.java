package service.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.DBService;

import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public abstract class DataAccessObject<T> {
    protected final static Logger log = Logger.getLogger(DataAccessObject.class);
    protected DBService service;
    private final Class<T> type;

    public DataAccessObject(DBService service, Class<T> type) {
        this.service = service;
        this.type = type;
    }

    public T get(long id){
        Session session = service.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T object = (T) session.get(type,id);
            transaction.commit();
            return object;
        }catch (HibernateException e) {
            if(transaction!=null) transaction.rollback();
            log.error(e);
            return null;
        }finally {
            session.close();
        }
    }


    public long insert(T object){
        Session session = service.getCurrentSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            long id =  (Long) session.save(object);
            transaction.commit();
            log.info(object + " inserted");
            return id;
        }catch (HibernateException e) {
            if(transaction!=null) transaction.rollback();
            log.error(e);
        }finally {
            session.close();
        }
        return -1;
    }

    public void update(T object){
        Session session = service.getCurrentSession();
        try{
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            log.info(object + " updated");
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            log.error(e);
        }finally {
            session.close();
        }
    }

    public void delete(T object){
        Session session = service.getCurrentSession();
        try{
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            log.info(object + " deleted");
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            log.error(e);
        }finally {
            session.close();
        }
    }

    public List<T> getAll(){
        Session session = service.getCurrentSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            List<T> clients = session.createQuery("FROM "+type.getSimpleName()).list();
            transaction.commit();
            return clients;
        }catch (HibernateException e){
            if(transaction!=null) transaction.rollback();
            log.error(e);
        }finally {
            session.close();
        }
        return null;
    }
}
