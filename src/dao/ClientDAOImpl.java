package dao;

import com.sun.istack.internal.NotNull;
import entity.Client;
import service.Executor;

import java.sql.SQLException;
import java.util.List;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class ClientDAOImpl implements ClientDAO {

    private Executor executor;
    private List<Client> list = null;

    public ClientDAOImpl(Executor executor) {
        this.executor = executor;
    }

    @Override
    public List<Client> getAllClients() {
        if (list==null){
            updateList();
        }
        return list;
    }

    public void updateList(){
        //TODO
    }
    @Override
    public Client getClient(int id) throws SQLException {
        return executor.execQuery("select * from Clients where client_id=" + id, result -> {
            result.next();
            Client client = new Client(result.getString(2), result.getInt(3),result.getString(4));
            client.setId(result.getInt(1));
            return client;
        });
    }

    @Override
    public void insertClient(@NotNull Client client) throws SQLException {
        executor.execUpdate("insert into Clients (client_id,fio,mobile_number,adress) values ('" + client.getId() +"','"+ client.getFio()+"','"+client.getMobileNumber() +"','"+ client.getAdress() + "')");
    }

    @Override
    public void updateClient(@NotNull Client client) {
        //TODO
    }

    @Override
    public void deleteClient(@NotNull Client client) {
        //TODO
    }
}
