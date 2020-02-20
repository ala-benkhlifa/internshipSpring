package tn.talan.internship.utilities;

import org.modelmapper.ModelMapper;
import tn.talan.internship.entities.Sale;
import tn.talan.internship.entities.SaleDTO;

public class SaleUtility {

    public SaleUtility() {
    }

    public static SaleDTO convertToDto(Sale sale) {
        SaleDTO productDTO =new SaleDTO();
        productDTO.setId(sale.getId());
        productDTO.setDate(sale.getDate());
        productDTO.setQuantity(sale.getQuantity());
        productDTO.setProduct(sale.getProduct());
        return productDTO;
    }

    public static Sale convertToEntity(SaleDTO saleDTO) {
        Sale product =new Sale();
        product.setId(saleDTO.getId());
        product.setDate(saleDTO.getDate());
        product.setQuantity(saleDTO.getQuantity());
        product.setProduct(saleDTO.getProduct());
        return product;
    }



}
