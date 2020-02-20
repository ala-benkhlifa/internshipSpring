package tn.talan.internship.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.talan.internship.entities.Sale;
import tn.talan.internship.dto.SaleDTO;
import tn.talan.internship.repositories.SaleRepository;
import tn.talan.internship.services.ISale;
import tn.talan.internship.utilities.SaleUtility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service("saleService")
@Primary
public class SaleServiceImpl implements ISale {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<SaleDTO> findAll() {
        return saleRepository
                .findAll()
                .stream()
                .map(SaleUtility::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Sale save(SaleDTO saleDTO) {
      Sale sale =  SaleUtility.convertToEntity(saleDTO);
        return saleRepository.save(sale);
    }

    @Override
    public boolean deleteById(Long idVente) {
        if (saleRepository.existsById(idVente)) {
            saleRepository.deleteById(idVente);
            return true;
        }
        return false;
    }



    @Override
    public Optional<SaleDTO> findById(Long idVente) {
        return saleRepository.findById(idVente).map(SaleUtility::convertToDto);
    }

}
