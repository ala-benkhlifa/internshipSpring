package tn.talan.internship.utilities;

import org.modelmapper.ModelMapper;
import tn.talan.internship.dto.SaleDTO;
import tn.talan.internship.entities.Sale;

public class SaleUtility {

    private SaleDTO convertToDto(Sale sale) {
        ModelMapper modelMapper = new ModelMapper();
        SaleDTO saleDto = modelMapper.map(sale, SaleDTO.class);
        return saleDto;
    }

    private Sale convertToEntity(SaleDTO saleDto)
    { ModelMapper modelMapper = new ModelMapper();
        Sale sale = modelMapper.map(saleDto, Sale.class);
        return sale;
    }
}
