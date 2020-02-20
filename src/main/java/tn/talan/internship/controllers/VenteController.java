package tn.talan.internship.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
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
public class VenteController {

    // Interface pour assurer un faible couplage
    @Autowired
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
    public Sale addSale(@RequestBody Sale Sale) {
        return service.save(Sale);
    }





    //delete a sale
    @DeleteMapping("/sale/{idVente}")
    public ResponseEntity removeSale(@PathVariable Long idVente) {
        if (service.deleteById(idVente)) {
            return ResponseEntity.ok("sale with id = " + idVente + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sale with id = " + idVente + " was not found!");
    }


    //search for a product by id
    @GetMapping("/sale/{idVente}")
    public ResponseEntity<Sale> getSaleById(@PathVariable(value = "idVente") Long idVente)
            throws ResourceNotFoundException {
        Sale sale = service.findById(idVente)
                .orElseThrow(() -> new ResourceNotFoundException("product not found for this id : " + idVente));
        return ResponseEntity.ok().body(sale);
    }

}
