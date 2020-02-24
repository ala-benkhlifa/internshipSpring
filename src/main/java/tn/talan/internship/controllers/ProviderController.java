package tn.talan.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;

import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.services.IProvider;

import java.util.List;


@Controller
@CrossOrigin("*")
public class ProviderController {

    @Autowired
    @Qualifier("providerService")
    private IProvider service;

    @ResponseBody
    @GetMapping("/providers")
    public List<ProviderDTO> getAllProviders() {
        return service.findAll();
    }


    //create and update a provider
    @ResponseBody
    @RequestMapping(value = "/provider" , method = {RequestMethod.POST, RequestMethod.PUT})
    public Provider addProvider(@RequestBody ProviderDTO provider) {

        return service.save(provider);
    }


    //delete a provider
    @DeleteMapping("/provider/{id}")
    public ResponseEntity removeProvider(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.ok("Provider with id = " + id + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provider with id = " + id + " was not found!");
    }




    //search for a product by id
    @GetMapping("/provider/{id}")
    public ResponseEntity<ProviderDTO> getProviderById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ProviderDTO providerDTO = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("provider not found for this id : " + id));
        return ResponseEntity.ok().body(providerDTO);
    }




}
