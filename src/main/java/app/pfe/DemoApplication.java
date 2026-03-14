package app.pfe;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import app.pfe.entity.Docteur;
import app.pfe.entity.Patient;
import app.pfe.entity.Rdv;
import app.pfe.service.DocteurService;
import app.pfe.service.PatientService;
import app.pfe.service.RdvService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    
    @Bean
    CommandLineRunner initRdv(RdvService rdvService, PatientService patientService, DocteurService docteurService){
        return args -> {
            Patient patient = patientService.getAllPatient().stream().findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Aucun patient trouve"));

            Docteur docteur = docteurService.getAllDocteurs().stream().findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Aucun docteur trouve"));

            Rdv rdv = new Rdv(LocalDateTime.now(), "10:00", patient, docteur);
            
            rdvService.addRdv(rdv, patient.getIdPatient(), docteur.getIdDocteur());

           


            
        };
    
    }
}

