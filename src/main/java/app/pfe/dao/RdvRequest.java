package app.pfe.dao;

import app.pfe.entity.Rdv;

public record RdvRequest(
    int idPatient,
    int idDocteur,
    Rdv rdv
) {
    
}
