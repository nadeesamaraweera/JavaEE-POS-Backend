package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO {
    boolean saveItem(ItemDTO itemDto) throws SQLException;
    ItemDTO searchItem(String id) throws SQLException;

    boolean updateItem(ItemDTO itemDto) throws SQLException;

    boolean deleteItem(String i) throws SQLException;

    List<ItemDTO> getAllItems() throws SQLException;
}
