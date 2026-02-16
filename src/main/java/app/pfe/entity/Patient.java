package app.pfe.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatient;

    private String nomPatient;
    private String prenomPatient;
    private String dNaissPatient;
    private String sexePatient;
    private String emailPatient;
    private String villePatient;
    private String adressePatient;
    private String telPatient;

    
    public Patient(String nomPatient, String prenomPatient, String dNaissPatient, String sexePatient,
            String emailPatient, String villePatient, String adressePatient, String telPatient) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dNaissPatient = dNaissPatient;
        this.sexePatient = sexePatient;
        this.emailPatient = emailPatient;
        this.villePatient = villePatient;
        this.adressePatient = adressePatient;
        this.telPatient = telPatient;
    }

    @OneToMany(mappedBy="patient")
    private List<Rdv> rdvs;

    public List<Rdv> getRdvs() {
        return rdvs;
    }
    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }

    public int getIdPatient() {
        return idPatient;
    }
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    public String getNomPatient() {
        return nomPatient;
    }
    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }
    public String getPrenomPatient() {
        return prenomPatient;
    }
    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }
    public String getdNaissPatient() {
        return dNaissPatient;
    }
    public void setdNaissPatient(String dNaissPatient) {
        this.dNaissPatient = dNaissPatient;
    }
    public String getSexePatient() {
        return sexePatient;
    }
    public void setSexePatient(String sexePatient) {
        this.sexePatient = sexePatient;
    }
    public String getEmailPatient() {
        return emailPatient;
    }
    public void setEmailPatient(String emailPatient) {
        this.emailPatient = emailPatient;
    }
    public String getVillePatient() {
        return villePatient;
    }
    public void setVillePatient(String villePatient) {
        this.villePatient = villePatient;
    }
    public String getAdressePatient() {
        return adressePatient;
    }
    public void setAdressePatient(String adressePatient) {
        this.adressePatient = adressePatient;
    }
    public String getTelPatient() {
        return telPatient;
    }
    public void setTelPatient(String telPatient) {
        this.telPatient = telPatient;
    }


}
