package app.pfe.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.pfe.entity.Patient;
import app.pfe.entity.Rdv;
import app.pfe.service.PatientService;
import app.pfe.service.RdvService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final RdvService rdvService;


    public PatientController(PatientService patientService, RdvService rdvService){
        this.patientService = patientService;
        this.rdvService = rdvService;
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> ajouterPatient(@RequestBody Patient patient) {
        try {
            return ResponseEntity.ok(patientService.addPatient(patient));
            
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erreur : " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        try {
            return ResponseEntity.ok(patientService.updatePatient(id, patient));

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException("Erreur : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePatient(@PathVariable int id) {
        try {

            return ResponseEntity.ok(patientService.deletePatientById(id));

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException("Erreur : " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Boolean> deletePatientByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(patientService.deletePatientByEmail(email));

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public List<Patient> getAllPatients() {
        
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}/rdvs") 
    public List<Rdv> getRdvsByPatient(@PathVariable int id) {
        return rdvService.getRdvsByPatientId(id); 
    }
    
        
    
    
    
}
