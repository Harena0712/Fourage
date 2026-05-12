package com.fourage.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fourage.model.*;
import com.fourage.service.*;

@Controller
public class DevisController {

    @Autowired
    private DemandeService demandeService;
    @Autowired
    private DevisService devisService;
    @Autowired
    private StatutDemandeService statutDemandeService;

    @GetMapping("/devis/formulaire")
    public ModelAndView formulaire() {
        List<Demande> demandes = demandeService.getAll();
        ModelAndView mv = new ModelAndView("Devis/formulaire");
        mv.addObject("demandes", demandes);
        return mv;
    }

    @PostMapping("/devis/ajouter")
    public ModelAndView ajouter(@RequestParam("idDemande") int idDemande,
                                @RequestParam("desc") String desc,
                                @RequestParam("qnt") int qnt,
                                @RequestParam("unite") String unite,
                                @RequestParam("PU") double PU,
                                @RequestParam("total") double total,
                                @RequestParam("daty") String daty) {

        try {
            Devis devis = new Devis();
            devis.setIdDemande(idDemande);
            devis.setDescription(desc);
            devis.setQnt(qnt);
            devis.setUnite(unite);
            devis.setPU(PU);
            devis.setTotal(total);
            devis.setDaty(LocalDateTime.parse(daty));

            devisService.save(devis);

            StatutDemande statutDemande = new StatutDemande();
            statutDemande.setIdDemande(idDemande);
            statutDemande.setIdStatut(2); // Statut "Devis reçus"
            statutDemande.setDaty(LocalDateTime.now());

            statutDemandeService.save(statutDemande);

            ModelAndView mv = new ModelAndView("/Devis/formulaire");
            mv.addObject("demandes", demandeService.getAll());
            mv.addObject("succes", "Devis ajouté avec succès");
            return mv;
        } catch (Exception e) {
            ModelAndView mv = new ModelAndView("/Devis/formulaire");
            mv.addObject("demandes", demandeService.getAll());
            mv.addObject("erreur", "Erreur lors de l'ajout du devis: " + e.getMessage());
            return mv;
        }
    }
}