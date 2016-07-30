package dao;

import entity.Admin;
import entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import service.DBService;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class AdminDAO extends DataAccessObject<Admin>  {

    public AdminDAO(DBService service) {
        super(service,Admin.class);
    }

    public long getId(String login){
        Session session = service.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Admin.class);
        long id =  ((Client) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
        session.getTransaction().commit();
        return id;
    }
}
