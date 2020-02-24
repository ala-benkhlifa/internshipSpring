package tn.talan.internship.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.talan.internship.dto.ProductDTO;
import tn.talan.internship.entities.Product;
import tn.talan.internship.repositories.ProductRepository;
import tn.talan.internship.services.IProduct;
import tn.talan.internship.utilities.ProductUtility;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service("productService")
@Primary
public class ProductServiceImpl implements IProduct {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductUtility::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteById(Long id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;

        }

        return false;
    }

    @Override
    public Optional <ProductDTO> findById(Long id) {
        return productRepository.findById(id).map(ProductUtility::toProductDto);
    }



}
