package service;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/31/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Context {
    private static Context ourInstance = new Context();

    public static Context getInstance() {
        if (ourInstance == null) {
            ourInstance = new Context();
        }

        return ourInstance;
    }

    private Context() {
    }
}
