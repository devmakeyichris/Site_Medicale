package app.pfe.service;

import org.apache.el.stream.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.pfe.component.JwtUtil;
import app.pfe.entity.Docteur;
import app.pfe.entity.Patient;
import app.pfe.repository.DocteurRepository;
import app.pfe.repository.PatientRepository;

@Service
public class AuthentificationService {
    
    private final PatientRepository patientRepository;
    private final DocteurRepository docteurRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AdminService adminService;
    
    public AuthentificationService(PatientRepository patientRepository,
    DocteurRepository docteurRepository,JwtUtil jwtUtil,PasswordEncoder passwordEncoder,AdminService adminService) {
        this.patientRepository = patientRepository;
        this.docteurRepository = docteurRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.adminService = adminService;
    }
    
    public String login(String email, String password) {
        Patient patient = patientRepository.findByEmailPatient(email).orElse(null);
        if (patient != null && passwordEncoder.matches(password, patient.getMotDePassePatient())) {
            return jwtUtil.generateToken(patient.getEmailPatient(), "PATIENT");
        }
        
        Docteur docteur = docteurRepository.findByEmailDocteur(email).orElse(null);
        if (docteur != null && passwordEncoder.matches(password, docteur.getMotDePasseDocteur())) {
            return jwtUtil.generateToken(docteur.getEmailDocteur(), "DOCTEUR");
        }
        
        Admin admin = adminService.findByEmail(email).orElse(null);
        if (admin != null && passwordEncoder.matches(password, admin.getMotDePasseAdmin())) {
            return jwtUtil.generateToken(admin.getEmailAdmin(), "ADMIN");
        }

        throw new IllegalArgumentException("Email ou mot de passe incorrect");
    }
    
    
    
    
    
    
}





