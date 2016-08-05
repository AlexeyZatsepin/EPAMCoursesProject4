package model.entity;

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
@Table(name="Bill")
public class Bill implements Serializable{
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_client_id")
    private Client from;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_client_id")
    private Client to;

    @Column(name = "amount")
    private long amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateOf")
    private java.util.Date timestamp;

    @SuppressWarnings("UnusedDeclaration")
    public Bill() {
    }

    public Bill(Client from, Client to, long amount, Date timestamp) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getFrom() {
        return from;
    }

    public void setFrom(Client from) {
        this.from = from;
    }

    public Client getTo() {
        return to;
    }

    public void setTo(Client to) {
        this.to = to;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
