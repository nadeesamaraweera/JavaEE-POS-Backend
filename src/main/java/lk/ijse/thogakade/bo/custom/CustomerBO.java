package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.dto.CustomerDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {

    boolean saveCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException;

    ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException;

//    CustomerDTO getCustomerById(Connection connection, String id) throws SQLException;

    boolean updateCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException;

    boolean deleteCustomer(Connection connection, String id) throws SQLException;
}
