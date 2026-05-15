package com.fourage.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "devis")
public class Devis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idDemande")
    private int idDemande;

    @Column(name = "idType")
    private int idType;

    @Column(name = "description")
    private String description;

    @Column(name = "daty")
    private LocalDateTime daty;

    public Devis() {
    }

    public Devis(int id, int idDemande, int idType, String description, LocalDateTime daty) {
        this.id = id;
        this.idDemande = idDemande;
        this.idType = idType;
        this.description = description;
        this.daty = daty;
    }

    public Devis(int idDemande, int idType, String description, LocalDateTime daty) {
        this.idDemande = idDemande;
        this.idType = idType;
        this.description = description;
        this.daty = daty;
    }

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

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDaty() {
        return daty;
    }

    public void setDaty(LocalDateTime daty) {
        this.daty = daty;
    }
}