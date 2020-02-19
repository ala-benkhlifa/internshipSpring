package tn.talan.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.talan.internship.entities.Product;
import tn.talan.internship.entities.Provider;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Long> {
    List<Provider> findByName(String text);

}
