package tn.talan.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.talan.internship.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
