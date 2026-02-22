package app.pfe.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import app.pfe.entity.Docteur;
import app.pfe.entity.Patient;
import app.pfe.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        if(patientRepository.existsByEmailPatient(patient.getEmailPatient())){
            throw new IllegalArgumentException("Un patient avec cet email existe déjà");
        }
        patientRepository.save(patient);
        return patient;
    }

    public Patient modifInfoPatient(Patient oldInfoPatient, Patient newInfoPatient) {

        BeanUtils.copyProperties(newInfoPatient, oldInfoPatient, "idPatient");
    
    return patientRepository.save(oldInfoPatient);
}


public boolean SuprimerPatient(Patient patient){
    if(patientRepository.existsById(patient.getIdPatient())){
        patientRepository.delete(patient);
    }
    return false;

}

public void supprimerPatientParEmail(String email){
    Patient patient = patientRepository.findByEmailPatient(email)
    .orElseThrow(() -> new IllegalArgumentException("Aucun patient ne possede cet email"));
    patientRepository.delete(patient);
}

public Patient RecherchPatientparId(int idPAtient){
    Patient patient = patientRepository.findById(idPAtient)
    .orElseThrow(() -> new IllegalArgumentException("le patient avec l'id " + idPAtient + " est introuvable"));
    return patient;
}


public List<Patient>  getAllPatient(){
        return patientRepository.findAll();
    }



}
