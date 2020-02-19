package tn.talan.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.talan.internship.entities.Product;
import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.repositories.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @ResponseBody
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //create a product
    @ResponseBody
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    //search for a product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }


    @GetMapping("/products/{name}")
    public List<Product> findByName(String name){
        return productRepository.findByName(name);

    }

    @GetMapping("/products/{price}")
    public List<Product> findByPrice(@PathVariable("price") Double price) {
        return productRepository.findByPrice(price);
    }


    //delete a product
    @PostMapping("/delete/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product with id = " + id + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id = " + id + " was not found!");
    }

    //updating a product
    @PutMapping("/products/{id}")
    public Product updateProduct(@Valid @RequestBody Product product) throws ResourceNotFoundException {
        return productRepository.save(product);
    }
}
