package model.entity;

import model.Constants;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/22/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@Entity
@Table(name= "Client")
public class Client implements Serializable{
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @Pattern(regexp = Constants.REGEX_WORD)
    private String firstName;

    @Column(name = "second_name")
    @Pattern(regexp = Constants.REGEX_WORD)
    private String secondName;

    @Column(name = "password")
    @Pattern(regexp = Constants.REGEX_PASSWORD_LONG)
    private String password;

    @Column(name = "mobile_number",unique = true)
    @Pattern(regexp = Constants.REGEX_PHONE)
    private int mobileNumber;

    @Column(name = "email")
    @Pattern(regexp = Constants.REGEX_MAIL)
    private String email;

    @Column(name = "adress")
    private String adress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<CreditCard> cards;

    @SuppressWarnings("UnusedDeclaration")
    public Client() {
    }

    public Client(String firstName,String secondName,String password,String email, int mobileNumber, String adress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<CreditCard> getCards() {
        return cards;
    }

    public void setCards(Set<CreditCard> cards) {
        this.cards = cards;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bill createBill(Client to, long amount){
        for (CreditCard card : cards){
            long current_amount = card.getPayment().getAmount();
            if (amount <= current_amount){
                card.getPayment().setAmount(current_amount - amount);
                return new Bill(this,to,amount,new Date(System.currentTimeMillis()));
            }
        }
        return null;
    }

    public long getTotal(){
        long total = 0;
        for (CreditCard creditCard : cards) {
            total += creditCard.getPayment().getAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", adress='" + adress + '\'' +
                '}';
    }
}
