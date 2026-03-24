package app.pfe.service;

import java.util.NoSuchElementException;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.pfe.entity.Admin;
import app.pfe.entity.Docteur;
import app.pfe.repository.AdminRepository;
import app.pfe.repository.DocteurRepository;

@Service
public class AdminService {

    
    private final AdminRepository adminRepository;
    private final DocteurRepository docteurRepository;

    public AdminService(AdminRepository adminRepository, DocteurRepository docteurRepository) {
        this.adminRepository = adminRepository;
        this.docteurRepository = docteurRepository;
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmailAdmin(email);
    }

    public void validerDocteur(int idDocteur) {

        Docteur docteur = docteurRepository.findById(idDocteur)
        .orElseThrow(() -> new NoSuchElementException("Docteur introuvable"));
            
        docteur.setValider(true);
        docteurRepository.save(docteur);
    }//bouton de valider


    
}
