package app.pfe.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.pfe.entity.Docteur;
import app.pfe.entity.Document;
import app.pfe.entity.Rdv;
import app.pfe.service.DocteurService;
import app.pfe.service.DocumentService;
import app.pfe.service.RdvService;




@RestController
@RequestMapping("/docteur")
public class DocteurController {

    private final RdvService rdvService;
    private final DocteurService docteurService;
    private final DocumentService documentService;

    
    public DocteurController(RdvService rdvService, DocteurService docteurService, DocumentService documentService) { 

        this.rdvService = rdvService; 
        this.docteurService = docteurService;
        this.documentService = documentService;
    } 

    @PostMapping("/add")
    public ResponseEntity<Docteur> putMethodName(@RequestBody Docteur docteur) {
        return ResponseEntity.ok(docteurService.addDocteur(docteur));
    }

    @PutMapping("/delete")
    public ResponseEntity<Boolean>  deleteDocteurById(@PathVariable int id) {
        return ResponseEntity.ok(docteurService.deleteDocteurById(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Docteur> updateDocteur(@PathVariable int id, @RequestBody Docteur docteur) {
        
        return ResponseEntity.ok(docteurService.updateDocteur(id, docteur));
        
        
    }
    
    
    @GetMapping("/{id}/rdvs")
        public ResponseEntity<List<Rdv>> getRdvsByDocteur(@PathVariable int id) {
        return ResponseEntity.ok(rdvService.getRdvsByDocteurId(id));
    }

    @GetMapping("/{id}/document")
    public ResponseEntity<List<Document>> getDocumentByDocteur(@PathVariable int id){
        return ResponseEntity.ok(documentService.findDocumentByIdDocteur(id));
    }
    
}
