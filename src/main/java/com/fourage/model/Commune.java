package com.fourage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "communes")
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "labelle")
    private String labelle;

    @Column(name = "idDistrict")
    private int idDistrict;

    @OneToMany(mappedBy = "idCommune")
    private List<Demande> demandes;

    public Commune() {
    }

    public Commune(int id, String labelle, int idDistrict) {
        this.id = id;
        this.labelle = labelle;
        this.idDistrict = idDistrict;
    }

    public Commune(String labelle, int idDistrict) {
        this.labelle = labelle;
        this.idDistrict = idDistrict;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public List<Demande> getIdDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
