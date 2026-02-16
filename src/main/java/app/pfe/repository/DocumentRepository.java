package app.pfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Document;

@Repository
public interface  DocumentRepository extends JpaRepository<Document, Integer> {

    Document findDocumentByDocteurEmail(String email);

    // Vérifier si un document existe déjà pour un docteur identifié par email 
    boolean existsByNomDocumentAndDocteur_Email(String nomDocument, String email); 
    
    // Récupérer tous les documents d’un docteur par email 
    List<Document> findByDocteur_Email(String email);
    
    // Récupérer un document précis par nom et email du docteur 
    
    Optional<Document> findByNomDocumentAndDocteur_Email(String nomDocument, String email); 
    
    // Supprimer un document par nom et email du docteur 
    void deleteByNomDocumentAndDocteur_Email(String nomDocument, String email);

    Optional<Document> findByNameDocument(String nomDocument);
    
}
