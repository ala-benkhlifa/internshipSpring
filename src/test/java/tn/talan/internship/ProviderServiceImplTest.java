package tn.talan.internship;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.repositories.ProviderRepository;
import tn.talan.internship.services.impl.ProviderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class ProviderServiceImplTest {

    @MockBean
    private ProviderRepository providerRepository;

    @Autowired
    private ProviderServiceImpl providerService;


    @Test
    public void PostProviderTest() {
        Provider provider = new Provider(3L, "Talan", "charguia", "développement");

        ProviderDTO providerDTO = new ProviderDTO(3L, "Talan", "charguia", "développement");
        Mockito.when(providerRepository.save(Mockito.any())).thenReturn(provider);
        ProviderDTO providerDTo = providerService.save(providerDTO);
        Assertions.assertNotNull(providerDTo);
    }


    @Test
    public void findAllTest() {
        List<Provider> ListeProviders = new ArrayList<>();

        Mockito.when(providerRepository.findAll()).thenReturn(ListeProviders);
        Provider providerOne = new Provider(1L, "Nabeul", "'informatique'", "'asus'");
        Provider providerTow = new Provider(2L, "'Manouba'", "'informatique'", "'HP'");
        ListeProviders.add(providerOne);
        ListeProviders.add(providerTow);

        List<ProviderDTO> ProvidersBd = providerService.findAll();
        assertThat(ProvidersBd.size()).isEqualTo(2);

    }


    @Test
    public void deleteByIdTest() {
        Provider provider = new Provider(1L, "Nabeul", "'informatique'", "'asus'");
        Mockito.when(providerRepository.existsById(1L)).thenReturn(true);
        assertTrue(providerRepository.existsById(1L));
    }


    @Test
    public void findByIdTest() {
        Provider  provider = new Provider (1L, "Nabeul", "'informatique'", "'asus'");
        Mockito.when(providerRepository.findById(1L)).thenReturn(Optional.of(provider));
        Assertions.assertNotNull(providerService.findById(1L));

    }

}
