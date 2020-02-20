package tn.talan.internship.services;

import tn.talan.internship.dto.ProductDTO;
import tn.talan.internship.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<ProductDTO> findAll();
    Product save(Product product);
    boolean deleteById (Long id);

    Optional<ProductDTO> findById(Long id);
}
