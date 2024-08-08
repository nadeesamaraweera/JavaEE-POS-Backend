package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOIMPL implements CustomerDAO {

    @Override
    public boolean save(Connection connection, Customer entity) throws SQLException {
        String sql = "INSERT INTO customer (id,name,address,salary) VALUES (?,?,?,?)";
        return CrudUtil.execute(connection,sql,entity.getId(),entity.getName(),entity.getAddress(),entity.getSalary());
    }

    @Override
    public boolean update(Connection connection, Customer entity) throws SQLException {
        String sql = "UPDATE customer SET name = ?, address = ?,salary = ? WHERE id = ?";
        return CrudUtil.execute(connection,sql,entity.getName(),entity.getAddress(),entity.getSalary(),entity.getId());
    }

    @Override
    public ArrayList<Customer> getAll(Connection connection) throws SQLException {
        String sql = "SELECT * FROM customer";
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ResultSet rst = CrudUtil.execute(connection, sql);
        System.out.println(customerList);
        while(rst.next()){
            Customer customer = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)

            );

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public boolean delete(Connection connection, String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE id=?";
        return CrudUtil.execute(connection,sql,id);
    }

}
