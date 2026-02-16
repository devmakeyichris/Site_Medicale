package app.pfe.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import app.pfe.entity.Docteur;
import app.pfe.repository.DocteurRepository;

@Service
public class DocteurService {

    private final  DocteurRepository docteurRepository;

    public DocteurService(DocteurRepository docteurRepository) {
        this.docteurRepository = docteurRepository;
    }





    public boolean saveDocteur(Docteur docteur){
        if(docteurRepository.existsDocteurByEmail(docteur.getEmailDocteur())){
            throw new IllegalArgumentException("Cet email existe deja");
        }
        docteurRepository.save(docteur);
        return true;
    }




    public Docteur findDocteurById(int id) {

    return docteurRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Docteur non trouvé avec id : " + id));
    }

    public Docteur findDocteurByEmail(String email) {

    return docteurRepository.findDocteurByEmail(email)
        .orElseThrow(() -> new RuntimeException("Docteur non trouvé avec email : " + email));
    }



    public boolean deleteDocteurByEmail(String email){

        Docteur docteur = findDocteurByEmail(email);
        docteurRepository.delete(docteur);
        return true;
    }


    public Docteur updateDocteur(Docteur oldDocteur, Docteur newDocteur) {

        BeanUtils.copyProperties(newDocteur, oldDocteur, "idDocteur");
        return docteurRepository.save(oldDocteur);
}



}
