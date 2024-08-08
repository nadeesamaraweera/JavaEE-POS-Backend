package lk.ijse.thogakade.bo;

import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBoFactory() {
        return (boFactory == null) ?
                boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, Order
    }

    public <T extends  SuperBO> T getBO(BOTypes types){
        switch (types){
            case CUSTOMER :
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
//            case ORDER_BO:
//                return (T) new OrderBOImpl();
//            case ORDER_DETAILS_BO:
//                return (T) new OrderDetailsBOImpl();

            default:
                return null;
        }
    }
}
