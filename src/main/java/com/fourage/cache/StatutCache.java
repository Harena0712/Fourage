package com.fourage.cache;

import com.fourage.model.*;
import com.fourage.service.*;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.InitializingBean;

@Component
public class StatutCache implements InitializingBean {

    // singleton instance
    private static StatutCache INSTANCE;

    // cache mémoire
    private Map<String, Statut> Statuts = new HashMap<>();

    @Autowired
    private StatutService StatutService;

    // constructeur public
    public StatutCache() {
    }

    // initialiser après injection de dépendances
    @Override
    public void afterPropertiesSet() throws Exception {
        INSTANCE = this;
        load();
    }

    // accès singleton
    public static StatutCache getInstance() {
        return INSTANCE;
    }

    // charger depuis fichier
    public void load() {
        Statuts.clear();

        List<Statut> liste = StatutService.getAll();

        for (Statut Statut : liste) {
            Statuts.put(Statut.getLibelle().toLowerCase(), Statut);
        }
    }

    // récupérer Statut
    public Statut getByStatut(String nom) {
        return Statuts.get(nom.toLowerCase());
    }
}