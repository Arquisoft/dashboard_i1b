package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dashboard.model.Citizen;
import dashboard.persistence.CitizenRepositoy;
import dashboard.services.CitizenService;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CitizenService citizenService) {
		return (args) -> {
			// save a couple of Citizens
			citizenService.save(new Citizen());
			citizenService.save(new Citizen());
			citizenService.save(new Citizen());
			citizenService.save(new Citizen());
			citizenService.save(new Citizen());

			// fetch all Citizens
			log.info("Citizens found with findAll():");
			log.info("-------------------------------");
			for (Citizen Citizen : citizenService.findAll()) {
				log.info(Citizen.toString());
			}
			log.info("");

		};
	}
}