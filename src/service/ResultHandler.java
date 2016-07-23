package service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/23/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
