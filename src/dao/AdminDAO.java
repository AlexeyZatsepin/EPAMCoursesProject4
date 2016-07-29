package dao;

import entity.Admin;
import entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class AdminDAO extends DataAccessObject<Admin>  {

    public AdminDAO(Session session) {
        super(session,Admin.class);
    }

    public long getId(String fio){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Admin.class);
        long id =  ((Client) criteria.add(Restrictions.eq("fio", fio)).uniqueResult()).getId();
        session.getTransaction().commit();
        return id;
    }
}
