package dao;

import entity.CreditCard;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class CreditCardDAO extends DataAccessObject<CreditCard> {

    public CreditCardDAO(Session session) {
        super(session,CreditCard.class);
    }


    public CreditCard findByPaymentId(long paymentId){
        return null; //TODO
    }

    public List<CreditCard> findByClientId(long clientId){
        return null; //TODOg
    }
    public List<CreditCard> findByExpiresDate(Date date){
        return null; //TODO
    }

    public List<CreditCard> findAllByProvider(String provider){
        return null; //TODO
    }
}
