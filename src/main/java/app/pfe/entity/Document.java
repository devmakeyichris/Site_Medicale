package app.pfe.entity;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocument;


    private String nomDocument;
    private String typeDocument;
    private String urlDocument;

    @ManyToOne
    @JoinColumn(name="idDocteur")
    private Docteur docteur;



    

    public Document(String nomDocument, String typeDocument, String urlDocument,Docteur docteur) {
        this.nomDocument = nomDocument;
        this.typeDocument = typeDocument;
        this.urlDocument = urlDocument;
        this.docteur = docteur;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public Docteur getDocteur() {
        return docteur;
    }

    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }


    
}
