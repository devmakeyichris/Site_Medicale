package app.pfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    // Vérifier si un document existe déjà pour un docteur identifié par email
    boolean existsByNomDocumentAndDocteur_EmailDocteur(String nomDocument, String emailDocteur); 
    
    // Récupérer tous les documents d’un docteur par email
    List<Document> findByDocteur_EmailDocteur(String emailDocteur);
    
    // Récupérer un document précis par nom et email du docteur
    Optional<Document> findByNomDocumentAndDocteur_EmailDocteur(String nomDocument, String emailDocteur); 
    
    // Supprimer un document par nom et email du docteur
    void deleteByNomDocumentAndDocteur_EmailDocteur(String nomDocument, String emailDocteur);

    // Récupérer un document par son nom
    Optional<Document> findByNomDocument(String nomDocument);
}

