package tn.talan.internship.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Long id ;
    private String name;
    private Double sellPrice;
    private Long quantity;

}
