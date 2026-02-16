package app.pfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Optional<Patient> findByEmail(String email);

    public boolean existByEmail(String email);

    public boolean deletePatientByEmail(String email);
    
}
