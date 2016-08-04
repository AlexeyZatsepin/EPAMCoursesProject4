package model.dao.impl;

import model.entity.Bill;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import model.service.DataBaseService;
import model.dao.AbstractGenericDAO;

import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/29/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class BillDAO extends AbstractGenericDAO<Bill> {

    public BillDAO(DataBaseService service) {
        super(service, Bill.class);
    }

    public List<Bill> findByDate(java.util.Date date){
        Session session = service.getSession();
        Criteria cr = session.createCriteria(Bill.class);
        cr.add(Restrictions.eq("dateOf", date));
        List<Bill> results = cr.list();
        session.close();
        return results;
    }
}
