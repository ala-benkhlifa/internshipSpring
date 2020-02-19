package tn.talan.internship.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.talan.internship.entities.Sale;
import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.repositories.SaleRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class VenteController {


    private final SaleRepository saleRepository;

    @Autowired
    public VenteController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    //get all ventes
    @ResponseBody
    @GetMapping("/sales")
    public List<Sale> getAllVentes() {
        return saleRepository.findAll();
    }

    //create a sale
    @ResponseBody
    @PostMapping("/sale")
    public Sale addSale(@RequestBody Sale Sale) {
        return saleRepository.save(Sale);
    }

    //updating a sale
    @PutMapping("/sale/{idVente}")
    public Sale updateSale(@Valid @RequestBody Sale sale) throws ResourceNotFoundException {
        return saleRepository.save(sale);
    }


    //delete a sale
    @DeleteMapping("/sale/{idVente}")
    public ResponseEntity removeSale (@PathVariable("idVente") Long idVente) {
        if (saleRepository.existsById(idVente)) {
            saleRepository.deleteById(idVente);
            return ResponseEntity.ok("sale with id = " + idVente + " has been deleted");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sale with id = " + idVente + " was not found!");
    }

    //search for a product by id
    @GetMapping("/sale/{idVente}")
    public Sale getSaleById(@PathVariable("idVente") Long idVente)
            throws ResourceNotFoundException {
        return saleRepository.findById(idVente)
                .orElseThrow(() -> new ResourceNotFoundException("product not found for this id : " + idVente));
    }

}
