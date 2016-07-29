package service;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/21/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@Deprecated
public class JDBCService{
    private static final String CONFIG_FILE = "local.properties";
    private static final String DRIVER = "db.driver";
    private static final String DB_NAME = "db.name";
    private static final String DB_URL = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_SETTING = "db.settings";
    private final static Logger logger = Logger.getLogger(JDBCService.class);
    private static JDBCService ourInstance = new JDBCService();
    private static Properties properties;
    private Executor executor;
    private Connection connection;

    public static JDBCService getInstance() {
        if (ourInstance == null) {
            ourInstance = new JDBCService();
        }
        return ourInstance;
    }

    private JDBCService() {
        properties = new Properties();
        try( InputStream in= new BufferedInputStream(
                new FileInputStream(CONFIG_FILE) ) ){
            properties.load(in);
        } catch (Exception ex) {
            logger.error("DB config file doesn't exist "+ex.getMessage());
        }
        connect();
        executor = new Executor(connection);
    }

    public void connect(){
        try {
            Driver driver = (Driver) Class.forName(properties.getProperty(DRIVER)).newInstance();
            DriverManager.registerDriver(driver);
            StringBuilder url = new StringBuilder(properties.getProperty(DB_URL));
            url.append(properties.getProperty(DB_NAME));
            url.append(properties.getProperty(DB_USER));
            url.append(properties.getProperty(DB_SETTING));
            logger.info(url.toString());
            connection = DriverManager.getConnection(url.toString());
        } catch (InstantiationException e) {
            logger.error("New instance can't be created "+ e.getMessage());
        } catch (IllegalAccessException e) {
            logger.error("Illegal access "+ e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error("Driver class not found "+ e.getMessage());
        } catch (SQLException e) {
            logger.error("Driver manager exception "+ e.getMessage());
        }

    }
    public Connection getConnection(){
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Can't close connection "+ e.getMessage());
        }
    }

    public Executor getExecutor(){
        return executor;
    }
}
