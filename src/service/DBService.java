package service;

import dao.*;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.File;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */

public class DBService{
    public final SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = new Configuration();
        configuration.configure(new File("hibernate.cfg.xml"));
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
    }

    public Session getCurrentSession(){
        return sessionFactory.openSession();
    }


    public DataAccessObject getDAO(Class cls) {
        if (cls == Client.class){
            return new ClientDAO(this);
        }else if(cls == Admin.class){
            return new AdminDAO(this);
        }else if(cls == Bill.class){
            return new BillDAO(this);
        }else if(cls == CreditCard.class){
            return new CreditCardDAO(this);
        }else if(cls == Payment.class){
            return new PaymentDAO(this);
        }
        return null;
    }

    public void close(){
        sessionFactory.close();
    }
}
