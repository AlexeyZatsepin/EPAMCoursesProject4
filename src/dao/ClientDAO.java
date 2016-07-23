package dao;

import com.sun.istack.internal.NotNull;
import entity.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public interface ClientDAO {
    List<Client> getAllClients();
    Client getClient(int id) throws SQLException;
    void insertClient(@NotNull Client client) throws SQLException;
    void updateClient(@NotNull Client client);
    void deleteClient(@NotNull Client client);
}
