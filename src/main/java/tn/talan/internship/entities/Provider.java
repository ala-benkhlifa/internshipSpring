package tn.talan.internship.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 20)
    private String name;
    private String adresse;
    private String domain;

}
