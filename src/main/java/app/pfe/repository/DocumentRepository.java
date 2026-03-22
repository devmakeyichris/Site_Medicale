package app.pfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    
    // Récupérer tous les documents d’un docteur par email
    List<Document> findByDocteur_EmailDocteur(String emailDocteur);
    
    // Récupérer un document précis par nom et email du docteur
    Optional<Document> findByNameDocument(String nomDocument, String emailDocteur); 
    
   
    // Récupérer un document par son nom
    Optional<Document> findByNameDocument(String nomDocument);



    boolean deleteByNameDocument(String nomDocument);

    boolean existsByNameDocument(String nomDocument);

    List<Document> findByDocteur_IdDocteur(int id);
}

