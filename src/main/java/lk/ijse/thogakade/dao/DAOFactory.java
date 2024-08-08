package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null) ? daoFactory = new DAOFactory() : daoFactory;

    }

    public enum DAOTypes{
        CUSTOMER
    }

    public <T extends SuperDAO> T getDAO (DAOTypes types){
        switch (types){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
//            case ITEM_DAO:
//                return (T) new ItemDAOImpl();
//            case ORDER_DAO:
//                return (T) new OrderDAOImpl();
//            case ORDER_DETAILS_DAO:
//                return (T) new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}


