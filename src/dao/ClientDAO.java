package dao;

import entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class ClientDAO extends DataAccessObject<Client> {

    public ClientDAO(Session session){
        super(session,Client.class);
    }

    public long getId(String fio){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Client.class);
        long id =  ((Client) criteria.add(Restrictions.eq("fio", fio)).uniqueResult()).getId();
        session.getTransaction().commit();
        return id;
    }

}
