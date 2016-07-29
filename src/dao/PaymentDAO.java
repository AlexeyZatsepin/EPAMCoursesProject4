package dao;

import entity.Payment;
import org.hibernate.Session;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class PaymentDAO extends DataAccessObject<Payment>{
    public PaymentDAO(Session session) {
        super(session, Payment.class);
    }
}
