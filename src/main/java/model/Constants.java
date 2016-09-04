package model;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/30/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public interface Constants {
    //Alex
    String REGEX_WORD="^[A-Za-z]+$";

    // biff777
    String REGEX_NICKNAME="^[A-Za-z0-9_-]{3,16}$";

    // «example@mail.com»
    String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    // «+38(044)555-55-55»
    String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";

    /**
     * Password matching expression.
     * Password must be at least 4 characters, no more than 8 characters,
     * and must include at least one upper case letter, one lower case letter,
     * and one numeric digit.
     */
    String REGEX_PASSWORD_LONG = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

    /**
     * pin code
     */
    String REGEX_PASSWORD_SHORT = "\\d{4}";

    String REGEX_CARD_ID = "\\d{16}";

    String HIBERNATE_CONFIG_FILE = "config/hibernate.cfg.xml";

    String LOG4J_CONFIG_FILE = "config/log4j.properties";

}
