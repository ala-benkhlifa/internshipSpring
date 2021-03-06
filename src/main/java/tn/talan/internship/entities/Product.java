package tn.talan.internship.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.talan.internship.enums.CategoryEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name;
    private Double price;
    private Double sellPrice;
    private Long quantity;
    private CategoryEnum category;
    @ManyToOne
    @JoinColumn(name = "idProvider")
    private Provider provider;
}
