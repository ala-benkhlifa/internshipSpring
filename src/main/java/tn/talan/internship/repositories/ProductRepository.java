package tn.talan.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.talan.internship.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
