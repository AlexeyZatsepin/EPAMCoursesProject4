package dao;

import entity.Client;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import service.DBService;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class ClientDAO extends DataAccessObject<Client> {

    public ClientDAO(DBService service){
        super(service,Client.class);
    }

    public long getId(String firstName, String secondName){
        Session session = service.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Client.class);
        long id =  ((Client) criteria.add(Restrictions.eq("first_name", firstName))
                .add(Restrictions.eq("second_name",secondName)).uniqueResult()).getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

}
