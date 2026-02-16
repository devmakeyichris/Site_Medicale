package app.pfe.service;
import java.util.List;

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



    public Document findDocumentByDocteurEmail(String email){
        return documentRepository.findDocumentByDocteurEmail(email);
    }

    // Ajouter un document

    public Document DocumentAjouterDocument(Document document) { 
        
        if (documentRepository.existsByNomDocumentAndDocteur_Email(document.getNomDocument(), document.getDocteur().getEmailDocteur())){ 
            throw new IllegalArgumentException("Ce docteur a déjà un document avec ce nom."); 
        } 
        return documentRepository.save(document); 
    } 



    
    // Ajouter un document avec gestion d'erreur
    
    public Document modifierDocument(String nomDocument, Document nouveauDocument) { 
        
        Document document = documentRepository.findByNameDocument(nomDocument) 
        .orElseThrow(() -> new IllegalArgumentException("Document introuvable.")); 
        
        if (!document.getNomDocument().equals(nouveauDocument.getNomDocument()) && documentRepository.existsByNomDocumentAndDocteur_Email(nouveauDocument.getNomDocument(), document.getDocteur().getEmailDocteur())){ 
            throw new IllegalArgumentException("Ce docteur a déjà un document avec ce nom."); 
        }
        document.setNomDocument(nouveauDocument.getNomDocument()); document.setTypeDocument(nouveauDocument.getTypeDocument()); document.setUrlDocument(nouveauDocument.getUrlDocument()); return documentRepository.save(document); 
    }
    //Bouton nom document


    // Supprimer un document par nom et email du docteur 
    public void supprimerDocumentParNomEtEmail(String nomDocument, String email) {
        documentRepository.deleteByNomDocumentAndDocteur_Email(nomDocument, email); 
    }
    //Bouton supprimer document



    // Lister les documents d’un docteur par email 
    public List<Document> listerDocumentsParDocteur(String email) { 

        return documentRepository.findByDocteur_Email(email); 
    }
}





    

