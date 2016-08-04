package model.service;

import model.dao.GenericDAO;
import model.dao.impl.*;
import model.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

import static model.Constants.HIBERNATE_CONFIG_FILE;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */

public class DataBaseService {
    public final SessionFactory sessionFactory;

    public DataBaseService() {
        Configuration configuration = new Configuration();
        configuration.configure(new File(HIBERNATE_CONFIG_FILE));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }


    public GenericDAO<Client> getClientDAO(){
            return new ClientDAO(this);
    }
    public GenericDAO<Admin> getAdminDAO(){
            return new AdminDAO(this);
    }
    public GenericDAO<Bill> getBillDAO(){
        return new BillDAO(this);
    }
    public GenericDAO<CreditCard> getCreditCardDAO(){
        return new CreditCardDAO(this);
    }
    public GenericDAO<Payment> getPaymentDAO(){
        return new PaymentDAO(this);
    }

    public void close(){
        sessionFactory.close();
    }
}
