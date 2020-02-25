package tn.talan.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.talan.internship.entities.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Long> {
    Provider findByName(String text);

}
