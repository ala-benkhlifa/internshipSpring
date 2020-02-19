package tn.talan.internship.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private Long id ;
    private String name;
    private Double sellPrice;
    private int quantity;

}
