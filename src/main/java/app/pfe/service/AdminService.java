package app.pfe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.pfe.entity.Admin;
import app.pfe.entity.Docteur;
import app.pfe.repository.AdminRepository;

@Service
public class AdminService {

    
    private final AdminRepository adminRepository;
    private final DocteurService docteurRepository;

    public AdminService(AdminRepository adminRepository, DocteurService docteurRepository) {
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
        Docteur docteur = docteurRepository.findDocteurById(idDocteur)
            .orElseThrow(() -> new IllegalArgumentException("Docteur introuvable"));
            
        docteur.setValider(true);
        docteurRepository.save(docteur);
    }


    
}
