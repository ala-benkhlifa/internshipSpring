package tn.talan.internship.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.talan.internship.entities.Sale;
import tn.talan.internship.dto.SaleDTO;
import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.services.ISale;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@CrossOrigin("*")
public class VenteController {

    // Interface pour assurer un faible couplage
    @Autowired
    @Qualifier("saleService")
    private ISale service;

    //get all ventes
    @ResponseBody
    @GetMapping("/sales")
    public List<SaleDTO>  getAllVentes() {
        return service.findAll();
    }


    //create and update a sale
    @ResponseBody
    @RequestMapping(value = "/sale" , method = {RequestMethod.POST, RequestMethod.PUT})
    public SaleDTO addSale(@RequestBody SaleDTO sale) {

        return service.save(sale);
    }


    //delete a sale
    @DeleteMapping("/sale/{idVente}")
    public ResponseEntity removeSale(@PathVariable Long idVente) {
        if (service.deleteById(idVente)) {
            return ResponseEntity.ok("sale with id = " + idVente + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sale with id = " + idVente + " was not found!");
    }


    //search for a sale by id
    @GetMapping("/sale/{idVente}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable(value = "idVente") Long idVente)
            throws ResourceNotFoundException {
        SaleDTO saleDTO = service.findById(idVente)
                .orElseThrow(() -> new ResourceNotFoundException("provider not found for this id : " + idVente));
        return ResponseEntity.ok().body(saleDTO);
    }

}
