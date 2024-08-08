package lk.ijse.thogakade.dao.custom;

import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.entity.OrderDetails;

import java.sql.SQLException;

public interface OrderDetailDAO extends SuperDAO {
    boolean save(OrderDetails entity) throws SQLException;

}
