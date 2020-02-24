package tn.talan.internship;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import tn.talan.internship.dto.ProviderDTO;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.repositories.ProviderRepository;
import tn.talan.internship.services.impl.ProviderServiceImpl;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class ProviderServiceImplTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks // auto inject helloRepository
    private ProviderServiceImpl providerService = new ProviderServiceImpl();


    @Test
    public void PostTest() {
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setName("test");
        providerDTO.setDomain("test2");
        providerDTO.setId(1L);
        providerDTO.setAdresse("tesst2");
        Provider provider = providerService.save(providerDTO);
        Assert.assertNotNull( "sorry but it's NULLLLLLLL",providerRepository.findByName(provider.getName()));
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    public void testGet() {
        Assert.assertEquals("hello my first Unit test you are beautiful", providerService.get());
    }

    @Test
    public void PostTests() {
        providerService.save(new ProviderDTO((long)1,"test", "test","bob@domain.com"));
        List<Provider> users = providerRepository.findAll();
        Assert.assertNull( users);
    }



}
