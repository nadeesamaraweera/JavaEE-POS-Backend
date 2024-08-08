package lk.ijse.thogakade.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class OrderDetails {

    private String orderId;
    private String itemId;
    private int qty;

}
