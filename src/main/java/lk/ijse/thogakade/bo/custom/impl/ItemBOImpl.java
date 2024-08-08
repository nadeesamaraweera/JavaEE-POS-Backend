package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public boolean saveItem(ItemDTO itemDto) throws SQLException {
        return itemDao.save(
                new Item(
                        itemDto.getId(),
                        itemDto.getName(),
                        itemDto.getQty(),
                        itemDto.getPrice()
                )
        );
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException {
        Item itemDto = itemDao.getData(id);

        if (itemDto != null) {
            return new ItemDTO(
                    itemDto.getId(),
                    itemDto.getName(),
                    itemDto.getQty(),
                    itemDto.getPrice()
            );
        }
        return null;
    }

    @Override
    public boolean updateItem(ItemDTO itemDto) throws SQLException {
        return itemDao.update(
                new Item(
                        itemDto.getId(),
                        itemDto.getName(),
                        itemDto.getQty(),
                        itemDto.getPrice()
                )
        );
    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return itemDao.delete(id);
    }

    @Override
    public List<ItemDTO> getAllItems() throws SQLException {
        List<Item> itemList = itemDao.getAll();

        List<ItemDTO> itemDtoList = new ArrayList<>();

        for (Item item : itemList) {
            itemDtoList.add(
                    new ItemDTO(
                            item.getId(),
                            item.getName(),
                            item.getQty(),
                            item.getPrice()
                    )
            );
        }

        return itemDtoList;
    }
}

