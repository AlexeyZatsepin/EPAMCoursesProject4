package service.dao;

import model.entity.Payment;
import service.DBService;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class PaymentDAO extends DataAccessObject<Payment>{
    public PaymentDAO(DBService service) {
        super(service, Payment.class);
    }
}
