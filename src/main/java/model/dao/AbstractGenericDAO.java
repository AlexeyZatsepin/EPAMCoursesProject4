package model.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.service.DataBaseService;

import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public abstract class AbstractGenericDAO<T> implements GenericDAO<T>{
    protected final static Logger log = Logger.getLogger(GenericDAO.class);
    protected DataBaseService service;
    protected final Class<T> type;

    public AbstractGenericDAO(DataBaseService service, Class<T> type) {
        this.service = service;
        this.type = type;
    }

    public T get(long id){
        Session session = service.getSession();
        Transaction transaction = null;
        T object = null;
        try {
            transaction = session.beginTransaction();
            object = (T) session.get(type,id);
            transaction.commit();
        }catch (HibernateException e) {
            if(transaction!=null) transaction.rollback();
            log.error(e);
        }finally {
            session.close();
        }
        return object;
    }


    public long insert(T object){
        Session session = service.getSession();
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
        Session session = service.getSession();
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
        Session session = service.getSession();
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
        Session session = service.getSession();
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
