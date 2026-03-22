package app.pfe.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.pfe.entity.Docteur;
import app.pfe.entity.Document;
import app.pfe.entity.Rdv;
import app.pfe.repository.DocteurRepository;
import app.pfe.repository.DocumentRepository;

@Service
public class DocteurService {

    private final  DocteurRepository docteurRepository;
    private final DocumentRepository documentRepository;
    private final PasswordEncoder passwordEncoder;

    public DocteurService(DocteurRepository docteurRepository,DocumentRepository documentRepository, PasswordEncoder passwordEncoder) {
        this.docteurRepository = docteurRepository;
        this.documentRepository = documentRepository;
        this.passwordEncoder = passwordEncoder;
    }





    public Docteur addDocteur(Docteur docteur){
        if(docteurRepository.existsDocteurByEmailDocteur(docteur.getEmailDocteur())){
            throw new IllegalArgumentException("Cet email existe deja");
        }
        docteur.setMotDePasseDocteur(passwordEncoder.encode(docteur.getMotDePasseDocteur()));
        docteur.setValider(false);
        docteurRepository.save(docteur);
        return docteur;
    }

    




    public Docteur findDocteurById(int id) {

    return docteurRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Docteur non trouvé avec id : " + id));
    }
    

    public List<Docteur> findDocteursValider() {
        return docteurRepository.findByValiderTrue();
    }



    public Docteur findDocteurByEmail(String email) {

    return docteurRepository.findByEmailDocteur(email)
        .orElseThrow(() -> new RuntimeException("Docteur non trouvé avec email : " + email));
    }



    public boolean deleteDocteurByEmail(String email){

        Docteur docteur = findDocteurByEmail(email);
        docteurRepository.deleteDocteurByEmailDocteur(email);
        return true;
    }

    public boolean deleteDocteurById(int idDocteur){
        Docteur docteur = docteurRepository.findById(idDocteur)
        .orElseThrow(() -> new IllegalArgumentException("Ce docteur n'existe pas"));

        docteurRepository.delete(docteur);
        return true;
    }

    public List<Docteur>  getAllDocteurs(){
        return docteurRepository.findAll();
    }


    public Docteur updateDocteur(int idDocteur, Docteur newDocteur) {
        Docteur  oldDocteur = docteurRepository.findById(idDocteur)
        .orElseThrow(() -> new IllegalArgumentException("Ce docteur n'existe pas"));

        BeanUtils.copyProperties(oldDocteur,newDocteur,"idDocteur");
        docteurRepository.save(oldDocteur);
        return oldDocteur;

    
}

public List<Rdv> getRdvsByDocteurId(int idDocteur) {

    Docteur doc = docteurRepository.findById(idDocteur) 
    .orElseThrow(() -> new RuntimeException("Docteur introuvable"));
    return doc.getRdvs(); } 



public List<Document> getDocumentsByDocteurId(int idDocteur) {

    Docteur doc = docteurRepository.findById(idDocteur) 
    .orElseThrow(() -> new RuntimeException("Docteur introuvable")); 

    return doc.getDocuments(); 
    
    }



}
