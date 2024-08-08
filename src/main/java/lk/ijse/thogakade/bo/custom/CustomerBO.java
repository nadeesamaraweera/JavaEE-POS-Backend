package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.dto.CustomerDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO {

    boolean saveCustomer(CustomerDTO customerDto) throws IOException, SQLException;
    CustomerDTO searchCustomer(String id) throws IOException, SQLException;

    boolean updateCustomer(CustomerDTO customerDto) throws SQLException;

    boolean deleteCustomer(String id) throws SQLException;

    List<CustomerDTO> getAllCustomers() throws SQLException;
}
