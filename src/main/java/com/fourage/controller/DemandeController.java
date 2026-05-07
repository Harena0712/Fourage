package com.fourage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.fourage.model.*;
import com.fourage.service.*;

@Controller
public class DemandeController {

    @Autowired
    private DemandeService demandeService;
    // @Autowired
    // private StatutService statutService;
    // @Autowired
    // private StatutDemandeService statutDemandeService;

    @GetMapping("/demande/formulaire")
    public ModelAndView formulaire() {
        ModelAndView mv = new ModelAndView("/Demandes/formulaire");
        return mv;
    }
    
    @PostMapping("/demande/ajouter")
    public ModelAndView ajouter(@RequestParam String nom, 
                                @RequestParam String prenom, 
                                @RequestParam int commune, 
                                @RequestParam String lieu) {

        
        Demande demande = new Demande();
        demande.setNom(nom);
        demande.setPrenom(prenom);
        demande.setRegion(region);
        demande.setDistrict(district);
        demande.setCommune(commune);
        demande.setLieu(lieu);
        demandeService.save(demande);
        
        ModelAndView mv = new ModelAndView("/Demandes/formulaire");
        mv.addObject("succes", "Demande ajoutée avec succès");
        return mv;
    }
}