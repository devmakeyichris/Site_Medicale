package app.pfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Docteur;



@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Integer> {


    Optional<Docteur> findDocteurByEmailDocteur(String email);

    boolean existsDocteurByEmailDocteur(String email);

    boolean deleteDocteurByEmailDocteur(String email);
    
}
