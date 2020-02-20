package tn.talan.internship.utilities;

import tn.talan.internship.entities.Sale;
import tn.talan.internship.dto.SaleDTO;

public class SaleUtility {

    public SaleUtility() {
    }

    public static SaleDTO convertToDto(Sale sale) {
        SaleDTO saleDTO =new SaleDTO();
        saleDTO.setId(sale.getId());
        saleDTO.setDate(sale.getDate());
        saleDTO.setQuantity(sale.getQuantity());
        saleDTO.setProduct(sale.getProduct());
        return saleDTO;
    }

    public static Sale convertToEntity(SaleDTO saleDTO) {
        Sale sale =new Sale();
        sale.setId(saleDTO.getId());
        sale.setDate(saleDTO.getDate());
        sale.setQuantity(saleDTO.getQuantity());
        sale.setProduct(saleDTO.getProduct());
        return sale;
    }



}
