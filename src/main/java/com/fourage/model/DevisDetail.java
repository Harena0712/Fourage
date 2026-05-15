package com.fourage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "devisDetails")
public class DevisDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idDevis")
    private int idDevis;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "qnt")
    private int qnt;

    @Column(name = "PU")
    private double PU;

    public DevisDetail() {
    }

    public DevisDetail(int id, int idDevis, String libelle, int qnt, double PU) {
        this.id = id;
        this.idDevis = idDevis;
        this.libelle = libelle;
        this.qnt = qnt;
        this.PU = PU;
    }

    public DevisDetail(int idDevis, String libelle, int qnt, double PU) {
        this.idDevis = idDevis;
        this.libelle = libelle;
        this.qnt = qnt;
        this.PU = PU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public int getIdDevis() {
        return idDevis;
    }

    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public double getPU() {
        return PU;
    }

    public void setPU(double PU) {
        this.PU = PU;
    }
}