package tn.talan.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.talan.internship.dto.ProductDTO;
import tn.talan.internship.entities.Product;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String text);
    List<Product> findByPrice(Double price);
}

