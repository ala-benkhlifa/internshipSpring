package tn.talan.internship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.talan.internship.entities.Provider;
import tn.talan.internship.repositories.ProviderRepository;

@Slf4j
@SpringBootApplication
public class InternshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipApplication.class, args);
	}

	// If we want to populate the database with some data, we can use this approach
	@Bean
	public CommandLineRunner commandLineRunner(ProviderRepository providerRepository) {
		// To avoid duplicate data
		if (providerRepository.findByName("Coca Cola") == null) {
			Provider provider = Provider.builder().name("Coca Cola").domain("Drinks").adresse("USA").build();
			providerRepository.save(provider);
			log.info(provider.toString());
		}
		return null;
	}
}
