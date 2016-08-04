package model.dao.impl;

import model.entity.Admin;
import model.entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import model.service.DataBaseService;
import model.dao.AbstractGenericDAO;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class AdminDAO extends AbstractGenericDAO<Admin> {

    public AdminDAO(DataBaseService service) {
        super(service,Admin.class);
    }

    public long getId(String login){
        Session session = service.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Admin.class);
        long id =  ((Client) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
        session.getTransaction().commit();
        return id;
    }

    public long isAdmin(String login,String password){
        Session session = service.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Admin.class);
        long id = ((Client) criteria.add(Restrictions.eq("password", password))
                .add(Restrictions.eq("login",login)).uniqueResult()).getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }
}
