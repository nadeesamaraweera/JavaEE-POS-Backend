package lk.ijse.thogakade.Util;

import lk.ijse.thogakade.dao.SuperDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface CrudUtil <T> extends SuperDAO {
    boolean save(T entity) throws SQLException;
    T getData(String id) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(String id) throws SQLException;
    List<T> getAll() throws SQLException;
}
