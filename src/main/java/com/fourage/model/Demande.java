package com.fourage.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "demandes")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idClient")
    private int idClient;
    
    @Column(name = "idCommune")
    private int idCommune;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "reference")
    private String reference;

    @Column(name = "daty")
    private LocalDateTime daty;

    @OneToMany(mappedBy = "idDemande")
    private List<StatutDemande> statutDemandes;

    public Demande(int id, int idClient, String lieu, int idCommune, String reference, LocalDateTime daty) {
        this.id = id;
        this.idClient = idClient;
        this.lieu = lieu;
        this.idCommune = idCommune;
        this.reference = reference;
        this.daty = daty;
    }

    public Demande(int idClient, String lieu, int idCommune, String reference, LocalDateTime daty) {
        this.idClient = idClient;
        this.lieu = lieu;
        this.idCommune = idCommune;
        this.reference = reference;
        this.daty = daty;
    }

    public Demande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getIdCommune() {
        return idCommune;
    }

    public void setIdCommune(int idCommune) {
        this.idCommune = idCommune;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDaty() {
        return daty;
    }

    public void setDaty(LocalDateTime daty) {
        this.daty = daty;
    }
}