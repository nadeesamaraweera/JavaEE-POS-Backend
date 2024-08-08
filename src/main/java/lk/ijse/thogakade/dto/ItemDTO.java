package lk.ijse.thogakade.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String id;
    private String name;
    private int qty;
    private double price;
}
