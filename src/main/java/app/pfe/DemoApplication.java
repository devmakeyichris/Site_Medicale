package app.pfe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import app.pfe.entity.Docteur;
import app.pfe.repository.*;
import app.pfe.service.DocteurService;
import app.pfe.service.PatientService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    CommandLineRunner init(DocteurService docta) {
    return args -> {
        Docteur doc = new Docteur(
            "ali", "Dongote", "email@example.com", "0612345678",
            "123 Rue Exemple", "Casablanca", "Cardiologie",
            "Description du docteur", null
        );
        docta.saveDocteur(doc);
    };
}






	

}
