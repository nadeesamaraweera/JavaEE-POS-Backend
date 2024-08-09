package lk.ijse.thogakade.bo;


import lk.ijse.thogakade.bo.SuperBO;
import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.bo.custom.impl.OrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBoFactory() {
        return (boFactory == null) ?
                boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, ORDER
    }

    public SuperBO getBO(BOTypes boTypes) {
        return switch (boTypes) {
            case CUSTOMER -> new CustomerBOImpl();
            case ITEM -> new ItemBOImpl();
            case ORDER -> new OrderBOImpl();
        };
    }
}
