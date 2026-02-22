package app.pfe.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import app.pfe.entity.Docteur;
import app.pfe.entity.Document;
import app.pfe.entity.Rdv;
import app.pfe.repository.DocteurRepository;

@Service
public class DocteurService {

    private final  DocteurRepository docteurRepository;

    public DocteurService(DocteurRepository docteurRepository) {
        this.docteurRepository = docteurRepository;
    }





    public boolean saveDocteur(Docteur docteur){
        if(docteurRepository.existsDocteurByEmailDocteur(docteur.getEmailDocteur())){
            throw new IllegalArgumentException("Cet email existe deja");
        }
        docteur.setValider(false);
        docteurRepository.save(docteur);
        return true;
    }




    public Docteur findDocteurById(int id) {

    return docteurRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Docteur non trouvé avec id : " + id));
    }

    public Docteur findDocteurByEmail(String email) {

    return docteurRepository.findDocteurByEmailDocteur(email)
        .orElseThrow(() -> new RuntimeException("Docteur non trouvé avec email : " + email));
    }



    public boolean deleteDocteurByEmail(String email){

        Docteur docteur = findDocteurByEmail(email);
        docteurRepository.deleteDocteurByEmailDocteur(email);
        return true;
    }

    public List<Docteur>  getAllDocteurs(){
        return docteurRepository.findAll();
    }


    public Docteur updateDocteur(Docteur oldDocteur, Docteur newDocteur) {

        BeanUtils.copyProperties(newDocteur, oldDocteur, "idDocteur");
        return docteurRepository.save(oldDocteur);
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
