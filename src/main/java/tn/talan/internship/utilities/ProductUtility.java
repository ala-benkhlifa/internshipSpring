package tn.talan.internship.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import tn.talan.internship.dto.ProductDTO;
import tn.talan.internship.entities.Product;

public class ProductUtility {

    public static ProductDTO toProductDto(Product product) {
        ProductDTO productDTO =new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setQuantity(product.getQuantity());
                productDTO.setSellPrice(product.getSellPrice());
                return  productDTO;
    }

    public static Product toProduct(ProductDTO productDTO) {
        Product product =new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setSellPrice(productDTO.getSellPrice());
        return  product;
    }

}
