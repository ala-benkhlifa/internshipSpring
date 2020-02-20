package tn.talan.internship.utilities;

import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;

public class ProviderUtility {

    public ProviderUtility() {
    }


    public static ProviderDTO convertToDto(Provider provider) {
        ProviderDTO providerDTO =new ProviderDTO();
        providerDTO.setId(provider.getId());
        providerDTO.setAdresse(provider.getAdresse());
        providerDTO.setDomain(provider.getDomain());
        providerDTO.setName(provider.getName());
        return providerDTO;
    }

    public static Provider convertToEntity(ProviderDTO providerDTO) {
        Provider provider =new Provider();
        provider.setId(providerDTO.getId());
        provider.setAdresse(providerDTO.getAdresse());
        provider.setDomain(providerDTO.getDomain());
        provider.setName(providerDTO.getName());
        return provider;
    }


}
