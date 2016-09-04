package model.dao.impl;

import model.dao.AbstractGenericDAO;
import model.entity.Payment;
import model.service.DataBaseService;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class PaymentDAO extends AbstractGenericDAO<Payment> {
    public PaymentDAO(DataBaseService service) {
        super(service, Payment.class);
    }
}
