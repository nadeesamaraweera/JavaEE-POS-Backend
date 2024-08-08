package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;


public class DAOFactory {
        private static DAOFactory daoFactory;

        private DAOFactory() {
        }

        public static DAOFactory getInstance() {
            return (daoFactory == null) ? (daoFactory = new DAOFactory()) : daoFactory;
        }

        public enum DAOType {
            CUSTOMER, ITEM, Order , OrderDetail
        }

    public <T extends SuperDAO> T getDAO (DAOType types){
        switch (types){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
//            case ORDER_DAO:
//                return (T) new OrderDAOImpl();
//            case ORDER_DETAILS_DAO:
//                return (T) new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}


