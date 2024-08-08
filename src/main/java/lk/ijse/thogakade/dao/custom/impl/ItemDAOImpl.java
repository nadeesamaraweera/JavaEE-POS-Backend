package lk.ijse.thogakade.dao.custom.impl;

import lk.ijse.thogakade.Util.SQLUtil;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    Connection connection;
    PreparedStatement preparedStatement;

    @Override
    public boolean save(Item item) throws SQLException {
        return SQLUtil.execute("INSERT INTO item VALUES (?,?,?,?)",
                item.getId(),
                item.getName(),
                item.getQty(),
                item.getPrice()
        );
    }

    @Override
    public Item getData(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item WHERE item_id=?", id);
        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public boolean update(Item item) throws SQLException {
        return SQLUtil.execute("UPDATE item SET item_name = ? , item_qty = ? , item_price = ? WHERE item_id=?",
                item.getName(),
                item.getQty(),
                item.getPrice(),
                item.getId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM item WHERE item_id=?", id);
    }

    @Override
    public List<Item> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item");
        List<Item> itemList = new ArrayList<>();
        while (resultSet.next()) {
            itemList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            ));
        }
        return itemList;
    }
}

