package lk.ijse.thogakade.dao.custom;

import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO extends SuperDAO {
    boolean save(Order entity) throws SQLException;
    List<Order> getAll() throws SQLException;
}
