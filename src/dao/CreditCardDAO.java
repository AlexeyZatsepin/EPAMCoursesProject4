package dao;

import entity.CreditCard;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import service.DBService;

import java.util.Date;
import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class CreditCardDAO extends DataAccessObject<CreditCard> {

    public CreditCardDAO(DBService service) {
        super(service,CreditCard.class);
    }


    public CreditCard findByPaymentId(long paymentId){
        Session session = service.getCurrentSession();
        Criteria cr = session.createCriteria(CreditCard.class);
        cr.add(Restrictions.eq("payment_id", paymentId));
        CreditCard result = (CreditCard) cr.uniqueResult();
        session.close();
        return result;
    }

    public List<CreditCard> findByClientId(long clientId){
        return findByRestriction(Restrictions.eq("client_id", clientId));
    }


    public List<CreditCard> findByExpiresDate(Date date){
        return findByRestriction(Restrictions.eq("date", date));
    }

    public List<CreditCard> findAllByProvider(String provider){
        return findByRestriction(Restrictions.eq("provider", provider));
    }

    private List<CreditCard> findByRestriction(Criterion criterion){
        Session session = service.getCurrentSession();
        Criteria cr = session.createCriteria(CreditCard.class);
        cr.add(criterion);
        List<CreditCard> result = cr.list();
        session.close();
        return result;
    }
}
