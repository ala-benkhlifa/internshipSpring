package tn.talan.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.talan.internship.entities.Product;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Date date;
    private Long quantity;
    private Product product;

}
