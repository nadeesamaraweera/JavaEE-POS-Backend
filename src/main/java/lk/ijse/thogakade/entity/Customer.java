package lk.ijse.thogakade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Customer {
    private String id;
    private String name;
    private String address;
    private Double salary;
}
