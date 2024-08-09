package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderBO extends SuperBO {


    boolean saveOrder(OrderDTO dto) throws SQLException;
    List<OrderDTO> getAllOrders() throws SQLException;
}
