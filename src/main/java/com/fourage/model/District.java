package com.fourage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "labelle")
    private String labelle;

    @Column(name = "idRegion")
    private int idRegion;

    @OneToMany(mappedBy = "idDistrict")
    private List<Commune> communes;

    public District() {
    }

    public District(int id, String labelle, int idRegion, List<Commune> communes) {
        this.id = id;
        this.labelle = labelle;
        this.idRegion = idRegion;
        this.communes = communes;
    }

    public District(String labelle, int idRegion, List<Commune> communes) {
        this.labelle = labelle;
        this.idRegion = idRegion;
        this.communes = communes;
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

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }
}
