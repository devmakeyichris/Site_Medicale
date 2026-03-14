package app.pfe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.pfe.entity.Document;
import app.pfe.service.DocteurService;
import app.pfe.service.DocumentService;



@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final DocteurService docteurService;

    public DocumentController( DocumentService documentService,DocteurService docteurService){
        this.documentService = documentService;
        this.docteurService = docteurService;
    }


    @PostMapping("/add")
    public ResponseEntity<Document> addDocument(@RequestBody Document document) {
        
        return  ResponseEntity.ok(documentService.AddDocument(document));
    }


    @PutMapping("update/{nomDocument}")
    public ResponseEntity<Document> updateDocument(@PathVariable String nomDocument, @RequestBody Document document) {
    
        return ResponseEntity.ok(documentService.updateDocument(nomDocument, document));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteDocument(@PathVariable int id){
        return ResponseEntity.ok(documentService.deleteDocumentById(id));

    }

    
    
}
