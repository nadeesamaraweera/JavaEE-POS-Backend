package lk.ijse.thogakade.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private String id;
    private String name;
    private int qty;
    private double price;
}
