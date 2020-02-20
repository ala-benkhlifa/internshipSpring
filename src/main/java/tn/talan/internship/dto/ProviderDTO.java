package tn.talan.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO {

    private Long id;
    private String name;
    private String adresse;
    private String domain;
}
