package tn.talan.internship;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tn.talan.internship.controllers.ProviderController;
import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.exception.ResourceNotFoundException;
import tn.talan.internship.services.impl.ProviderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class ProviderControllerTest {


    @Autowired
    ProviderController providerController;

    @MockBean
    ProviderServiceImpl Service;

    @Test
    public void getAllProvidersTest() {
        List<ProviderDTO> ListeProviders = new ArrayList<>();

        Mockito.when(Service.findAll()).thenReturn(ListeProviders);
        ProviderDTO providerOne = new ProviderDTO(1L, "Nabeul", "'informatique'", "'asus'");
        ProviderDTO providerTow = new ProviderDTO(2L, "'Manouba'", "'informatique'", "'HP'");
        ListeProviders.add(providerOne);
        ListeProviders.add(providerTow);

        List<ProviderDTO> ProvidersBd = providerController.getAllProviders();
        assertThat(ProvidersBd.size()).isEqualTo(2);

    }

    @Test
    public void addProviderTest() {
        ProviderDTO provider = new ProviderDTO(3L, "Talan", "charguia", "développement");
        Mockito.when(Service.save(Mockito.any())).thenReturn(provider);
        ProviderDTO providerDTO = new ProviderDTO(3L, "Talan", "charguia", "développement");
        ProviderDTO providerDB = providerController.addProvider(providerDTO);
        Assertions.assertNotNull(providerDB);

    }

    @Test
    public void removeProviderTest() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(Service.deleteById(1L)).thenReturn(true);
        ResponseEntity<Object> responseEntity = providerController.removeProvider(1L);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

    }



    @Test
    public void getProviderByIdTest() {
        ProviderDTO provider = new ProviderDTO(1L, "Nabeul", "'informatique'", "'asus'");

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(Service.findById(1L)).thenReturn(Optional.of(provider));
        ResponseEntity<ProviderDTO> responseEntity = null;
        try {
            responseEntity = providerController.getProviderById(1L);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

    }

}
