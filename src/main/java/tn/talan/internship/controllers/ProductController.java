package tn.talan.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.talan.internship.dto.ProductDTO;
import tn.talan.internship.entities.Product;
import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.services.IProductService;
import java.util.List;



@Controller
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService service;


    //get all ventes
    @ResponseBody
    @GetMapping("/product")
    public List<ProductDTO>  getAllProducts() {
        return service.findAll();
    }


    //create and update a sale
    @ResponseBody
    @RequestMapping(value = "/product" , method = {RequestMethod.POST, RequestMethod.PUT})
    public Product addProduct(@RequestBody ProductDTO productDTO) {
        return service.save(productDTO);
    }


    //delete a sale
    @DeleteMapping("/product/{id}")
    public ResponseEntity removeProduct(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.ok("product with id = " + id + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sale with id = " + id + " was not found!");
    }


    //search for a product by id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ProductDTO product = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found for this id : " + id));
        return ResponseEntity.ok().body(product);
    }


}
