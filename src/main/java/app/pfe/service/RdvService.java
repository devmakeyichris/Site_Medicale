package app.pfe.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import app.pfe.entity.Docteur;
import app.pfe.entity.Patient;
import app.pfe.entity.Rdv;
import app.pfe.repository.DocteurRepository;
import app.pfe.repository.PatientRepository;
import app.pfe.repository.RdvRepository;

@Service
public class RdvService {

    private final RdvRepository rdvRepository;
    private final PatientRepository patientRepository;
    private final DocteurRepository docteurRepository;

    public RdvService(RdvRepository rdvRepository, PatientRepository patientRepository, DocteurRepository docteurRepository) {
        this.rdvRepository = rdvRepository;
        this.patientRepository = patientRepository;
        this.docteurRepository = docteurRepository;
    }


    public Rdv creerRdv(Rdv rdv, int idPatient, int idDocteur){

        Docteur idDoc = docteurRepository.findById(idDocteur).
        orElseThrow(() -> new IllegalArgumentException("Le docteur ayant l'id" + idDocteur +"n'existe pas !"));

        Patient idPat = patientRepository.findById(idPatient).
        orElseThrow(() -> new IllegalArgumentException("Le patient ayant l'id" + idPatient + "n'existe pas !"));

        boolean dejaPris = verifierDisponibiliteRdv(rdv);

        if(dejaPris){
            throw new IllegalArgumentException("Ce creneau est deja pris !");
        }

        rdv.setStatusRdv("Attente de confirmation");

        return rdvRepository.save(rdv);

    }
//Lorsque le patient sera connecte et aura pris le rendez-vous,le front envera en http l'id du docteur,du patient et les infos du rdv au back pour que le back puisse faire le lien entre les trois et creer le rdv dan s la base de donnee






    public String verifierRdv(Rdv rdv) {
        LocalDateTime maintenant = LocalDateTime.now();

        if (rdv.getDateRdv().isBefore(maintenant.plusHours(24))) {//si le rendez‑vous est prévu dans moins de 24h.
            return "Confirmation requise avant ce rendez-vous.";
        }
        return "Rendez-vous toujours en attente de confirmation.";
    }

    public Rdv confirmerRdv(Rdv rdv) {

    rdv.setStatusRdv("CONFIRMÉ");

    return rdvRepository.save(rdv);
    }
   //Dans le front , il y auura un bouton comfirmer rdv

    

    public boolean verifierDisponibiliteRdv(Rdv rdv){

        LocalDateTime dateRdv = rdv.getDateRdv();

        String heureRdv = rdv.getHeureRdv();

        int idDocteur = rdv.getDocteur().getIdDocteur();

        return rdvRepository.existsByDateRdvAndHeureRdvAndDocteur_idDocteur(dateRdv,heureRdv,idDocteur);
    }





    public Rdv modifierRdv(Rdv oldRdv, Rdv newRdv){

        BeanUtils.copyProperties(newRdv, oldRdv, "idRdv");
        return rdvRepository.save(oldRdv);

    
    }


    public Rdv annulerRdv(Rdv rdv){

        rdv.setStatusRdv("ANNULE");
        return rdvRepository.save(rdv);
    }


    public Rdv findById(int idRdv) {
        Rdv rdv = rdvRepository.findById(idRdv)
        .orElseThrow(() -> new IllegalArgumentException("Aucun rendez vous avec cet Id"));
        return rdv;
    }












    
}
