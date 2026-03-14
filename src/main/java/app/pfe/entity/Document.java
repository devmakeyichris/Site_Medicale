package app.pfe.entity;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocument;


    private String nameDocument;
    private String typeDocument;
    private String urlDocument;

    @ManyToOne
    @JoinColumn(name="idDocteur")
    private Docteur docteur;



    public Document(){}

    public Document(String nameDocument, String typeDocument, String urlDocument,Docteur docteur) {
        this.nameDocument = nameDocument;
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

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
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
