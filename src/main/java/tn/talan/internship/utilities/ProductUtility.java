package tn.talan.internship.utilities;

import org.modelmapper.ModelMapper;
import tn.talan.internship.dto.ProductDTO;
import tn.talan.internship.entities.Product;

public class ProductUtility {
    ModelMapper modelMapper;

    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return productDTO;
    }

    private Product convertToEntity(ProductDTO productDTO)
    {
        Product product  = modelMapper.map(productDTO, Product.class);
        return product;
    }
}
