package dao;

import entity.Bill;
import org.hibernate.Session;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class BillDAO extends DataAccessObject<Bill> {

    public BillDAO(Session session) {
        super(session, Bill.class);
    }

    public Bill findByDate(){
        return null; // TODO
    }
}
