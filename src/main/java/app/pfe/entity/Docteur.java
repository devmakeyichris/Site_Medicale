package app.pfe.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Docteur {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idDocteur; 
    
    private String nomDocteur;  
    private String prenomDocteur; 
    private String emailDocteur; 
    private String telephoneDocteur; 
    private String adresseDocteur; 
    private String villeDocteur; 
    private String specialiteDocteur; 
    private String descDocteur;
    private Boolean valider;

    

    @OneToMany(mappedBy = "docteur",cascade = CascadeType.ALL)
    private List<Document> documents;


    

    @OneToMany(mappedBy="docteur",cascade = CascadeType.ALL)
    private List<Rdv> rdvs;



    public Docteur(String nomDocteur, String prenomDocteur, String emailDocteur, String telephoneDocteur,
            String adresseDocteur, String villeDocteur, String specialiteDocteur, String descDocteur,
            List<Document> documents) {
        this.nomDocteur = nomDocteur;
        this.prenomDocteur = prenomDocteur;
        this.emailDocteur = emailDocteur;
        this.telephoneDocteur = telephoneDocteur;
        this.adresseDocteur = adresseDocteur;
        this.villeDocteur = villeDocteur;
        this.specialiteDocteur = specialiteDocteur;
        this.descDocteur = descDocteur;
        this.documents = documents;
    }
    public Integer getIdDocteur() {
        return idDocteur;
    }
    public void setIdDocteur(Integer idDocteur) {
        this.idDocteur = idDocteur;
    }
    public String getNomDocteur() {
        return nomDocteur;
    }
    public void setNomDocteur(String nomDocteur) {
        this.nomDocteur = nomDocteur;
    }
    public String getPrenomDocteur() {
        return prenomDocteur;
    }
    public void setPrenomDocteur(String prenomDocteur) {
        this.prenomDocteur = prenomDocteur;
    }
    public String getEmailDocteur() {
        return emailDocteur;
    }
    public void setEmailDocteur(String emailDocteur) {
        this.emailDocteur = emailDocteur;
    }
    public String getTelephoneDocteur() {
        return telephoneDocteur;
    }
    public void setTelephoneDocteur(String telephoneDocteur) {
        this.telephoneDocteur = telephoneDocteur;
    }
    public String getAdresseDocteur() {
        return adresseDocteur;
    }
    public void setAdresseDocteur(String adresseDocteur) {
        this.adresseDocteur = adresseDocteur;
    }
    public String getVilleDocteur() {
        return villeDocteur;
    }
    public void setVilleDocteur(String villeDocteur) {
        this.villeDocteur = villeDocteur;
    }
    public String getSpecialiteDocteur() {
        return specialiteDocteur;
    }
    public void setSpecialiteDocteur(String specialiteDocteur) {
        this.specialiteDocteur = specialiteDocteur;
    }
    public String getDescDocteur() {
        return descDocteur;
    }
    public void setDescDocteur(String descDocteur) {
        this.descDocteur = descDocteur;
    }
    public Boolean getValider() {
        return valider;
    }
    public void setValider(Boolean valider) {
        this.valider = valider;
    } 

    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }
    
}
