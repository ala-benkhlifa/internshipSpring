package tn.talan.internship.services;

import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;

import java.util.List;
import java.util.Optional;

public interface IProvider {


    List<ProviderDTO> findAll();

    Provider save(ProviderDTO providerDTO);

    boolean deleteById(Long id);

    Optional<ProviderDTO> findById(Long id);


}
