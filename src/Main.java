import dao.ClientDAO;
import dao.ClientDAOImpl;
import entity.Client;
import service.Executor;
import service.JDBCService;

import java.sql.SQLException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/17/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Main{
    public static void main(String[] args) throws SQLException {
        JDBCService connector = JDBCService.getInstance();
        Client client = new Client("bla",1268,"asa");
        ClientDAO dao = new ClientDAOImpl(new Executor(connector.getConnection()));
        dao.insertClient(client);
        System.out.println(dao.getClient(1));
        connector.close();

    }
}
