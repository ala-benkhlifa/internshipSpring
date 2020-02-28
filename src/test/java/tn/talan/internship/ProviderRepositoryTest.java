package tn.talan.internship;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.repositories.ProviderRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "classpath:provider_insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:provider_delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@TestPropertySource("classpath:application-test.properties")
public class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;


    @Test
    public void GetAllProvider() {
        List<Provider> ProvidersBd = providerRepository.findAll();
        System.out.println(ProvidersBd.get(3));
        assertThat(ProvidersBd.size()).isEqualTo(3);
    }

    @Test
    public void saveTest() {
        Provider NewProvider = new Provider();
        NewProvider.setName("Nokia");
        NewProvider.setDomain("phones");
        NewProvider.setId(6L);
        NewProvider.setAdresse("Tunis");
        Provider provider = providerRepository.save(NewProvider);
        Provider getproviderDb = providerRepository.findById(provider.getId()).orElse(null);
        Assertions.assertNotNull(getproviderDb);
    }

    @Test
    public void findByIdTest() {
        Provider getproviderDb = providerRepository.findById(15L).orElse(null);
        Assertions.assertNotNull(getproviderDb);
    }

    @Test
    public void deleteByIdTest() {
        providerRepository.deleteById(15L);
        Provider getproviderDb = providerRepository.findById(15L).orElse(null);
        Assertions.assertNull(getproviderDb);
    }

    @Test
    public void UpdateProviderByid() {
        Provider NewProvider = new Provider();
        NewProvider.setName("Nokia");
        NewProvider.setDomain("phones");
        NewProvider.setId(15L);
        NewProvider.setAdresse("Tunis");
        Provider provider = providerRepository.save(NewProvider);
        Provider getproviderDb = providerRepository.findById(provider.getId()).orElse(null);
        assertThat(getproviderDb).isEqualTo(provider);
    }


}
