package app.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Docteur;
import java.util.List;
import java.util.Optional;



@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Integer> {

    boolean existByEmail(String emailDocteur);

    Optional<Docteur> findDocteurByEmail(String email);

    boolean existsDocteurByEmail(String email);

    boolean deleteDocteurByEmail(String email);
    
}
