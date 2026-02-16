package app.pfe.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Rdv{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idRdv;

    private LocalDateTime dateRdv;
    private String heureRdv;
    private String statusRdv;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "idDocteur")
    private Docteur docteur;



    public Rdv(LocalDateTime dateRdv, String heureRdv) {
        this.dateRdv = dateRdv;
        this.heureRdv = heureRdv;
    }

    
    public int getIdRdv() {
        return idRdv;
    }
    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }
    public LocalDateTime getDateRdv() {
        return dateRdv;
    }
    public void setDateRdv(LocalDateTime dateRdv) {
        this.dateRdv = dateRdv;
    }
    public String getHeureRdv() {
        return heureRdv;
    }
    public void setHeureRdv(String heureRdv) {
        this.heureRdv = heureRdv;
    }
    public String getStatusRdv() {
        return statusRdv;
    }
    public void setStatusRdv(String statusRdv) {

        this.statusRdv = statusRdv;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Docteur getDocteur() {
        return docteur;
    }
    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }

    
}
