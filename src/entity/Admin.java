package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/22/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@Entity
@Table(name = "Admin")
public class Admin implements Serializable {
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "mobile_number",unique = true)
    private int mobileNumber;

    @SuppressWarnings("UnusedDeclaration")
    public Admin(){}

    public Admin(String fio, int mobileNumber) {
        this.fio = fio;
        this.mobileNumber = mobileNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void blockCreditCard(Payment payment){
        payment.setBlocked(true);
    }

    public void unBlockCreditCard(Payment payment){
        payment.setBlocked(false);
    }
}
