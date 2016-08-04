package model.dao.impl;

import model.entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import model.service.DataBaseService;
import model.dao.AbstractGenericDAO;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class ClientDAO extends AbstractGenericDAO<Client> {

    public ClientDAO(DataBaseService service){
        super(service,Client.class);
    }

    public long getId(String firstName, String secondName){
        Session session = service.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Client.class);
        long id =  ((Client) criteria.add(Restrictions.eq("first_name", firstName))
                .add(Restrictions.eq("second_name",secondName)).uniqueResult()).getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public long isValidUser(String email,String password){
        Session session = service.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Client.class);

        System.out.println(email);
        System.out.println(password);

        long id = ((Client) criteria.add(Restrictions.eq("password", password))
                .add(Restrictions.eq("email",email)).uniqueResult()).getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

}
