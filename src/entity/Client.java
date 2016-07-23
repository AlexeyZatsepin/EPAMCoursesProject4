package entity;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/22/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Client{
    private long id;
    private String fio;
    private int mobileNumber;
    private String adress;

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
}
