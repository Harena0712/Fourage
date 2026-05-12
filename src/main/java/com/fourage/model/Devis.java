package com.fourage.model;

import java.time.LocalDateTime;
import java.util.List;

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
    
    @Column(name = "qnt")
    private int qnt;

    @Column(name = "unite")
    private String unite;
    
    @Column(name = "PU")
    private double PU;

    @Column(name = "description")
    private String description;
    
    @Column(name = "total")
    private double total;

    @Column(name = "daty")
    private LocalDateTime daty;

    public Devis(int id, int idDemande, int qnt, String unite, double PU, String description, double total, LocalDateTime daty) {
        this.id = id;
        this.idDemande = idDemande;
        this.qnt = qnt;
        this.unite = unite;
        this.PU = PU;
        this.description = description;
        this.total = total;
        this.daty = daty;
    }

    public Devis(int idDemande, int qnt, String unite, double PU, String description, double total, LocalDateTime daty) {
        this.idDemande = idDemande;
        this.qnt = qnt;
        this.unite = unite;
        this.PU = PU;
        this.description = description;
        this.total = total;
        this.daty = daty;
    }

    public Devis() {
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

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getPU() {
        return PU;
    }

    public void setPU(double PU) {
        this.PU = PU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getDaty() {
        return daty;
    }

    public void setDaty(LocalDateTime daty) {
        this.daty = daty;
    }
}