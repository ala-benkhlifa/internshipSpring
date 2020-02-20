package tn.talan.internship.services;

import tn.talan.internship.entities.Sale;
import tn.talan.internship.dto.SaleDTO;

import java.util.List;
import java.util.Optional;

public interface ISale {

    List<SaleDTO> findAll();
    Sale save(Sale Sale);
    boolean deleteById (Long idVente);

    Optional<Sale> findById(Long idVente);
}
