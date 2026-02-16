package app.pfe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.pfe.dao.RdvRequest;
import app.pfe.entity.Rdv;
import app.pfe.service.DocteurService;
import app.pfe.service.PatientService;
import app.pfe.service.RdvService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rdv")
public class RdvController {

    private final DocteurService docteurService;

    private RdvService rdvService;

    private final PatientService patientService;

    public RdvController(DocteurService docteurService,PatientService patientService,RdvService rdvService){
        this.docteurService = docteurService;
        this.patientService = patientService;
        this.rdvService = rdvService;
    }

    @PostMapping("/creeRdv")
    public ResponseEntity<Rdv> creerRdv(@RequestBody RdvRequest rdvRequest) {
        Rdv rdv = rdvService.creerRdv(rdvRequest.rdv(), rdvRequest.idPatient(), rdvRequest.idDocteur());
        return ResponseEntity.ok(rdv);
    }


    @PutMapping("/annulerRdv") 
    public ResponseEntity<Rdv> annulerRdv(@RequestBody Rdv rdv){
        Rdv annuler = rdvService.annulerRdv(rdv); 
        return ResponseEntity.ok(annuler); 
    }

    @PutMapping("/confirmer")
    public ResponseEntity<Rdv> confirmerRdv(@RequestBody Rdv rdv){
        Rdv confirme = rdvService.confirmerRdv(rdv); 
        return ResponseEntity.ok(confirme); 
    }


    // @PutMapping("/verifier")
    // public ResponseEntity<String> verifierRdv(@RequestBody Rdv rdv){
    //    )
        
    // }



    








    
    
}
