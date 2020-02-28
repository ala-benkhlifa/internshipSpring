package tn.talan.internship.dto;

import lombok.Data;
import tn.talan.internship.enums.CategoryEnum;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Long id ;
    private String name;
    private Double price;
    private Double sellPrice;
    private Long quantity;
    private CategoryEnum category;

}
