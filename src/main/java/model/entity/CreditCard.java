package model.entity;

import model.Constants;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/22/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@Entity
@Table(name = "CreditCard")
public class CreditCard implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "card_number")
    //@Pattern(regexp = Constants.REGEX_CARD_ID)
    private String number;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expires_end")
    private Date expiresEnd;


    @Column(name="provider", columnDefinition="enum('VISA','MASTERCARD')")
    private String provider;

    @Column(name = "password", columnDefinition = "0000", length = 4)
    @Pattern(regexp = Constants.REGEX_PASSWORD_SHORT)
    private String password;

    @Column(name = "is_blocked")
    private boolean isBlocked;


    @SuppressWarnings("UnusedDeclaration")
    public CreditCard(){}

    public CreditCard(Client client, Payment payment, String password, int cvv, Date expiresEnd, String provider) {
        this.client = client;
        this.payment = payment;
        this.password = password;
        this.cvv = cvv;
        this.expiresEnd = expiresEnd;
        this.provider = provider;
        this.isBlocked = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(byte cvv) {
        this.cvv = cvv;
    }

    public Date getExpiresEnd() {
        return expiresEnd;
    }

    public void setExpiresEnd(Date expiresEnd) {
        this.expiresEnd = expiresEnd;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", client=" + client +
                ", payment=" + payment +
                ", cvv=" + cvv +
                ", expiresEnd=" + expiresEnd +
                ", provider='" + provider + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
