package model.entity;

import model.Constants;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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

    @Column(name = "login")
    @Pattern(regexp = Constants.REGEX_NICKNAME)
    private String login;

    @Column(name = "password")
    @Pattern(regexp = Constants.REGEX_PASSWORD_LONG)
    private String password;

    @Column(name = "mobile_number",unique = true)
    @Pattern(regexp = Constants.REGEX_PHONE)
    private int mobileNumber;

    @SuppressWarnings("UnusedDeclaration")
    public Admin(){}

    public Admin(String login, int mobileNumber) {
        this.login = login;
        this.mobileNumber = mobileNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFio() {
        return login;
    }

    public void setFio(String fio) {
        this.login = fio;
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
