package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.Util.SQLUtil;
import lk.ijse.thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.thogakade.entity.OrderDetails;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public static String SAVE_ORDER_ITEM_DETAIL = "INSERT INTO order_item_detail (order_id, item_id, qty) VALUES(?,?,?)";

    @Override
    public boolean save(OrderDetails entity) throws SQLException {
        return SQLUtil.execute(SAVE_ORDER_ITEM_DETAIL,
                entity.getOrderId(),
                entity.getItemId(),
                entity.getQty()
        );
    }
}
