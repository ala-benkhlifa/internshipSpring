package tn.talan.internship.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.repositories.ProviderRepository;
import tn.talan.internship.services.IProvider;
import tn.talan.internship.utilities.ProviderUtility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service("providerService")
public class ProviderServiceImpl implements IProvider {

    public ProviderServiceImpl() {

    }


    private ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository ProviderServiceImpl, ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }



    @Override
    public List<ProviderDTO> findAll() {
        return providerRepository
                .findAll()
                .stream()
                .map(ProviderUtility::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProviderDTO save(ProviderDTO providerDTO) {
        Provider provider = ProviderUtility.convertToEntity(providerDTO);
        Provider providerRepo  =providerRepository.save(provider);
        return ProviderUtility.convertToDto(providerRepo);



    }


    @Override
    public boolean deleteById(Long id) {
        if (providerRepository.existsById(id)) {
            providerRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Optional<ProviderDTO> findById(Long id) {
        return providerRepository.findById(id).map(ProviderUtility::convertToDto);
    }



}
