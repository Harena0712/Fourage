package com.fourage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "labelle")
    private String labelle;

    @OneToMany(mappedBy = "idRegion")
    private List<District> districts;

    public Region() {
    }

    public Region(int id, String labelle, List<District> districts) {
        this.id = id;
        this.labelle = labelle;
        this.districts = districts;
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

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
