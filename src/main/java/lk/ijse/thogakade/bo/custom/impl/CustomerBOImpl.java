package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDto) throws IOException, SQLException {
        return customerDao.save(
                new Customer(
                        customerDto.getId(),
                        customerDto.getName(),
                        customerDto.getAddress(),
                        customerDto.getSalary()
                )
        );

    }

    @Override
    public CustomerDTO searchCustomer(String id) throws IOException, SQLException {
        Customer customer = customerDao.getData(id);
        if (customer != null) {
            System.out.println(customer+"=============================== bo");
            return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDto) throws SQLException {
        return customerDao.update(
                new Customer(
                        customerDto.getId(),
                        customerDto.getName(),
                        customerDto.getAddress(),
                        customerDto.getSalary()
                )
        );
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDao.delete(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws SQLException {
        List<Customer> customerList = customerDao.getAll();

        if (customerList != null) {
            return customerList.stream().map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary())).toList();
        } else {
            return null;
        }

    }
}
