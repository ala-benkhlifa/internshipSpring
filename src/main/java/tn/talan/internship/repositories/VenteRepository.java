package tn.talan.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.talan.internship.entities.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Long> {
}
