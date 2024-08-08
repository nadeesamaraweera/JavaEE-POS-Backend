package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

        CustomerDAO customerDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        @Override
        public boolean saveCustomer(Connection connection, CustomerDTO dto) throws SQLException {
            return customerDAO.save(connection,new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()));
        }

        @Override
        public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException {
            ArrayList<Customer> customersList = customerDAO.getAll(connection);
            ArrayList<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer : customersList) {
                CustomerDTO dto = new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getSalary()
                );
                customerDTOList.add(dto);
            }
            return customerDTOList;
        }



        @Override
        public boolean updateCustomer(Connection connection, CustomerDTO dto) throws SQLException {
            return customerDAO.update(connection,new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()));

        }

        @Override
        public boolean deleteCustomer(Connection connection, String id) throws SQLException {
            return customerDAO.delete(connection,id);


        }
    }


