package lk.ijse.thogakade.dao.custom;

import lk.ijse.thogakade.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    boolean save(Connection connection, Customer entity) throws SQLException;

    boolean update(Connection connection, Customer entity) throws SQLException;

    ArrayList<Customer> getAll(Connection connection) throws SQLException;

    boolean delete(Connection connection, String id) throws SQLException;
}
