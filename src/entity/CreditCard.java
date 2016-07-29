package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/22/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@Entity
@Table(name = "Credit_card")
public class CreditCard implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "cvv",unique = true)
    private int cvv;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expires_end")
    private java.util.Date expiresEnd;


    @Column(name="provider", columnDefinition="enum('VISA','MASTERCARD')")
    private String provider;



    @SuppressWarnings("UnusedDeclaration")
    public CreditCard(){}

    public CreditCard(Client client, Payment payment, int cvv, Date expiresEnd, String provider) {
        this.client = client;
        this.payment = payment;
        this.cvv = cvv;
        this.expiresEnd = expiresEnd;
        this.provider = provider;
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
}
