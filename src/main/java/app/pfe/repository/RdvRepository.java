package app.pfe.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Rdv;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Integer> {

    boolean existsByDateRdvAndHeureRdvAndDocteur_idDocteur(LocalDateTime dateRdv, String heureRdv, int idDocteur);

    List<Rdv> findByPatient_IdPatient(int idPatient); 
    
    List<Rdv> findByDocteur_IdDocteur(int idDocteur);
    
}
