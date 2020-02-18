package tn.talan.internship.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vente implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVente ;
    private Date dateVente;
    private int qteVente ;

}
