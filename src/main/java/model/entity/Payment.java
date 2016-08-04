package model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/22/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@Entity
@Table(name = "Payment")
public class Payment implements Serializable{
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount")
    private long amount;

    @Column(name = "is_blocked")
    private boolean isBlocked;


    @SuppressWarnings("UnusedDeclaration")
    public Payment(){}

    public Payment(long amount) {
        this.amount = amount;
        isBlocked = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }


}
