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
@Table(name="Clients")
public class Client implements Serializable{
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "mobile_number",unique = true)
    private int mobileNumber;

    @Column(name = "adress")
    private String adress;

    @SuppressWarnings("UnusedDeclaration")
    public Client() {
    }

    public Client(String fio, int mobileNumber, String adress) {
        this.fio = fio;
        this.mobileNumber = mobileNumber;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void createBill(Client to,long amount){
        //TODO
    }


}
