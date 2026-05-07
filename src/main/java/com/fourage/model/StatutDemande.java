package com.fourage.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "statutDemandes")
public class StatutDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idDemande")
    private int idDemande;

    @Column(name = "idStatut")
    private int idStatut;

    @Column(name = "daty")
    private LocalDateTime daty;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdDemande() {
        return idDemande;
    }
    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public int getIdStatut() {
        return idStatut;
    }
    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public LocalDateTime getDaty() {
        return daty;
    }
    public void setDaty(LocalDateTime daty) {
        this.daty = daty;
    }

}
