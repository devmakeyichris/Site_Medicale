package app.pfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Optional<Patient> findByEmailPatient(String email);

    public boolean existsByEmailPatient(String email);

    public boolean deleteByEmailPatient(String email);
    
}
