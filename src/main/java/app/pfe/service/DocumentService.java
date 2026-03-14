package app.pfe.service;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import app.pfe.entity.Document;
import app.pfe.repository.DocteurRepository;
import app.pfe.repository.DocumentRepository;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    private final DocteurRepository docteurRepository;

    public DocumentService(DocumentRepository documentRepository,DocteurRepository docteurRepository){
        this.documentRepository = documentRepository;
        this.docteurRepository = docteurRepository;
    }



    public List<Document> findDocumentByDocteurEmail(String email){
        return documentRepository.findByDocteur_EmailDocteur(email);
    }

    // Ajouter un document

    public Document AddDocument(Document document) { 
        
        if (documentRepository.existsByName(document.getNameDocument())){
            new IllegalArgumentException("Ce document exist deja !");
        }

        documentRepository.save(document);
        return document;
    }



    
    
    public Document updateDocument(String nomDocument, Document nouveauDocument) { 
        
        Document document = documentRepository.findByNomDocument(nomDocument) 
        .orElseThrow(() -> new IllegalArgumentException("Document introuvable.")); 
        
        BeanUtils.copyProperties(document,nouveauDocument,"idDocument");
        return documentRepository.save(document); 
    }
    //Bouton nom document         


    // Supprimer un document par nom 
    public boolean deleteDocumentByName(String nomDocument) {
        if(documentRepository.existsByName(nomDocument)){

            documentRepository.deleteByName(nomDocument); 
            return true;

        }
        return false;
        
    }

    public boolean deleteDocumentById(int idDocument){
        if(documentRepository.existsById(idDocument)){
            documentRepository.deleteById(idDocument);
            return true;
        }
        return false;

    }
    //Bouton supprimer document



    // Lister les documents d’un docteur par id
    public List<Document> findDocumentByIdDocteur(int id) { 

        return documentRepository.findByDocteur_IdDocteur(id); 
    }



}





    

