package com.fourage.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "statuts")
public class Statut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "sigle")
    private String sigle;

    @OneToMany(mappedBy = "idStatut")
    private List<StatutDemande> statutDemandes;

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

    public String getSigle() {
        return sigle;
    }
    public void setSigle(String sigle) {
        this.sigle = sigle;
    } 

    public List<StatutDemande> getStatutDemandes() {
        return statutDemandes;
    }
    public void setStatutDemandes(List<StatutDemande> statutDemandes) {
        this.statutDemandes = statutDemandes;
    }
}
