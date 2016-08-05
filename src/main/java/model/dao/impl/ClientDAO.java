package model.dao.impl;

import model.dao.AbstractGenericDAO;
import model.entity.Client;
import model.service.DataBaseService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class ClientDAO extends AbstractGenericDAO<Client> {

    private static final String HQL_BY_NAME ="FROM Client E WHERE E.firstName = :firstName AND E.secondName = :secondName";;

    private static final String HQL_EMAIL_PASSWORD = "FROM Client E WHERE E.password = :password AND E.email = :email";

    public ClientDAO(DataBaseService service){
        super(service,Client.class);
    }

    public long getUserByName(String firstName, String secondName){
        Session session = service.getSession();
        Transaction transaction = null;
        long id = -1;
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(HQL_BY_NAME);
            query.setParameter("firstName", firstName);
            query.setParameter("secondName", secondName);
            Client client = (Client)query.uniqueResult();
            if (client != null ) id = client.getId();
            transaction.commit();
        }catch (HibernateException e) {
            if(transaction!=null) transaction.rollback();
            log.error(e);
        }finally {
            session.close();
        }
        return id;
    }

    public long getUserByParams(String email, String password){
        Session session = service.getSession();
        Transaction transaction = null;
        long id = -1;
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(HQL_EMAIL_PASSWORD);
            query.setParameter("password", password);
            query.setParameter("email", email);
            Client client = (Client)query.uniqueResult();
            if (client != null ) id = client.getId();
            transaction.commit();
        }catch (HibernateException e) {
            if(transaction!=null) transaction.rollback();
            log.error(e);
        }finally {
            session.close();
        }
        return id;
    }

}
