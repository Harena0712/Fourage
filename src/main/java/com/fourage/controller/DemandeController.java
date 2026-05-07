package com.fourage.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fourage.model.*;
import com.fourage.service.*;
import com.fourage.util.*;

@Controller
public class DemandeController {

    @Autowired
    private DemandeService demandeService;
    @Autowired
    private ClientService clientService;
    // @Autowired
    // private StatutDemandeService statutDemandeService;

    @GetMapping("/demande/formulaire")
    public ModelAndView formulaire() {
        ModelAndView mv = new ModelAndView("/Demandes/formulaire");
        return mv;
    }
    
    @PostMapping("/demande/ajouter")
    public ModelAndView ajouter(@RequestParam("nom") String nom, 
                                @RequestParam("prenom") String prenom, 
                                @RequestParam("idCommune") int idCommune, 
                                @RequestParam("lieu") String lieu,
                                @RequestParam("date") String date) {

        List<Client> clients = clientService.getByNomPrenom(nom, prenom);
        if(clients.isEmpty()) {
            ModelAndView mv = new ModelAndView("/Demandes/formulaire");
            mv.addObject("erreur", "Client non trouvé, veuillez vois inscrire d'abord");
            return mv;
        }
        
        Client client = clients.get(0);
        String ref = ReferenceGenerator.genererReference();

        Demande demande = new Demande();
        demande.setIdClient(client.getId());
        demande.setLieu(lieu);
        demande.setIdCommune(idCommune);
        demande.setDaty(LocalDateTime.parse(date));
        demande.setReference(ref);

        demandeService.save(demande);
        
        ModelAndView mv = new ModelAndView("/Demandes/formulaire");
        mv.addObject("succes", "Demande ajoutée avec succès");
        return mv;
    }
}