package tn.talan.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.talan.internship.entities.Product;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.repositories.ProviderRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    private ProviderRepository providerRepository;

    @ResponseBody
    @GetMapping("/providers")
    public List<Provider> getAllProducts() {
        return providerRepository.findAll();
    }
    //create a provider
    @ResponseBody
    @PostMapping("/provider")
    public Provider addProvider(@RequestBody Provider provider) {
        return providerRepository.save(provider);
    }

    //search for a provider by id
    @GetMapping("/provider/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable(value = "id") Long providerId)
            throws ResourceNotFoundException {
        Provider provider= providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + providerId));
        return ResponseEntity.ok().body(provider);
    }


    @GetMapping("/provider/name/{name}")
    @ResponseBody
    public List<Provider> findByName(@PathVariable(value = "name") String name){
        return providerRepository.findByName(name);

    }



    //delete a provider
    @DeleteMapping("/delete/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        if (providerRepository.existsById(id)) {
            providerRepository.deleteById(id);
            return ResponseEntity.ok("Product with id = " + id + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id = " + id + " was not found!");
    }

    //updating a product
    @PutMapping("/provider/{id}")
    public Provider updateProduct(@Valid @RequestBody Provider provider) throws ResourceNotFoundException {
        return providerRepository.save(provider);
    }
}
