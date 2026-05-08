package com.fourage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "communes")
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "idDistrict")
    private int idDistrict;

    @OneToMany(mappedBy = "idCommune")
    private List<Demande> demandes;

    public Commune() {
    }

    public Commune(int id, String libelle, int idDistrict) {
        this.id = id;
        this.libelle = libelle;
        this.idDistrict = idDistrict;
    }

    public Commune(String libelle, int idDistrict) {
        this.libelle = libelle;
        this.idDistrict = idDistrict;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Demande> getIdDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
