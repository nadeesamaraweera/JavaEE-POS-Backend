package lk.ijse.thogakade.dao;


import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrderDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrderDetailDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DAOFactory()) : daoFactory;
    }

    public enum DAOType {
        CUSTOMER, ITEM, ORDER , ORDER_DETAIL
    }

    public SuperDAO getDAO(DAOType daoType) {
        return switch (daoType) {
            case CUSTOMER -> new CustomerDAOImpl();
            case ITEM -> new ItemDAOImpl();
            case ORDER -> new OrderDAOImpl();
            case ORDER_DETAIL -> new OrderDetailDAOImpl();
        };
    }
}
