package app.pfe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.pfe.dao.RdvRequest;
import app.pfe.entity.Rdv;
import app.pfe.service.DocteurService;
import app.pfe.service.PatientService;
import app.pfe.service.RdvService;


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

    @PostMapping("/add")
    public ResponseEntity<Rdv> addRdv(@RequestBody RdvRequest rdvRequest) {
        Rdv rdv = rdvService.addRdv(rdvRequest.rdv(), rdvRequest.idPatient(), rdvRequest.idDocteur());
        return ResponseEntity.ok(rdv);
    }


    @PutMapping("/deleteRdv") 
    public ResponseEntity<Rdv> deleteRdv(@RequestBody Rdv rdv){
        Rdv annuler = rdvService.deleteRdv(rdv); 
        return ResponseEntity.ok(annuler); 
    }

    @PutMapping("/confirmRdv")
    public ResponseEntity<Rdv> confirmRdv(@RequestBody Rdv rdv){
        Rdv confirme = rdvService.confirmRdv(rdv); 
        return ResponseEntity.ok(confirme); 
    }


    @PutMapping("/checkRdv")
        public ResponseEntity<String> checkRdv(@RequestBody Rdv rdv){
            String message = rdvService.checkRdv(rdv);
            return ResponseEntity.ok(message);
    }

    @PutMapping("/updateRdv")
    public ResponseEntity<Rdv> updateRdv(@RequestBody RdvRequest rdvRequest) {
        
        Rdv oldRdv = rdvService.findById(rdvRequest.rdv().getIdRdv());

        if(oldRdv == null){
            return ResponseEntity.notFound().build();
        }
        Rdv modifie = rdvService.updateRdv(oldRdv, rdvRequest.rdv());
        
        return ResponseEntity.ok(modifie);
    }



    








    
    
}
