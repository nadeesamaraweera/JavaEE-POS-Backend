package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.thogakade.db.ConnectionManager;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.entity.Order;
import lk.ijse.thogakade.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO =
            (OrderDAO) DAOFactory.getInstance()
                    .getDAO(DAOFactory.DAOType.Order);

    OrderDetailDAO orderItemDetailDAO =
            (OrderDetailDAO) DAOFactory.getInstance()
                    .getDAO(DAOFactory.DAOType.OrderDetail);

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        boolean isOrderSaved;
        boolean isOrderItemSaved = true;
        connection.setAutoCommit(false);

        // Save order
        isOrderSaved = orderDAO.save(new Order(
                dto.getId(),
                dto.getDate(),
                dto.getCustomerId(),
                Double.parseDouble(dto.getTotal()),
                dto.getDiscount(),
                Double.parseDouble(dto.getSubTotal()),
                Double.parseDouble(dto.getCash()),
                Double.parseDouble(dto.getBalance())
        ));

        // Save order items
        if (isOrderSaved) {
            for (ItemDTO item : dto.getItems()) {
                boolean isOrderItemDetailSaved = orderItemDetailDAO.save(new OrderDetails(
                        dto.getId(),
                        item.getId(),
                        item.getQty()
                ));
                if (!isOrderItemDetailSaved) {
                    connection.rollback(); // Rollback transaction on failure
                    isOrderItemSaved = false;
                    break;
                }
            }
        }

        if (isOrderSaved && isOrderItemSaved) {
            connection.commit();
        } else {
            connection.rollback();
        }
        connection.setAutoCommit(true);
        return isOrderSaved;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws SQLException {
        List<Order> orderEntities = orderDAO.getAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orderEntities) {
            orderDTOS.add(
                    new OrderDTO(
                            order.getId(),
                            order.getDate(),
                            order.getCustomerId(),
                            null,
                            String.valueOf(order.getTotal()),
                            order.getDiscount(),
                            String.valueOf(order.getSubTotal()),
                            String.valueOf(order.getCash()),
                            String.valueOf(order.getBalance())
                    ));
        }
        return orderDTOS;
    }
}
