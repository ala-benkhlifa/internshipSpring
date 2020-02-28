package tn.talan.internship.services;

import tn.talan.internship.dto.SaleDTO;

import java.util.List;
import java.util.Optional;

public interface ISale {

    List<SaleDTO> findAll();

    SaleDTO save(SaleDTO SaleDTO);

    boolean deleteById(Long idVente);

    Optional<SaleDTO> findById(Long idVente);
}
