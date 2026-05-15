package com.fourage.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private StatutService statutService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CommuneService communeService;
    @Autowired
    private StatutDemandeService statutDemandeService;

    @GetMapping("/demande/formulaire")
    public ModelAndView formulaire() {
        List<Commune> communes = communeService.getAll();
        ModelAndView mv = new ModelAndView("/Demandes/formulaire");
        mv.addObject("communes", communes);
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
            mv.addObject("communes", communeService.getAll());
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

        Statut demandeRecu = statutService.getById(1);

        StatutDemande statutDemande = new StatutDemande();
        statutDemande.setIdDemande(demande.getId());
        statutDemande.setIdStatut(demandeRecu.getId()); // Statut "Demande reçue"
        statutDemande.setDaty(LocalDateTime.parse(date));
        
        statutDemandeService.save(statutDemande);

        ModelAndView mv = new ModelAndView("/Demandes/formulaire");
        mv.addObject("succes", "Demande ajoutée avec succès");
        mv.addObject("communes", communeService.getAll());
        return mv;
    }

    @GetMapping("/demande/lister")
    public ModelAndView lister() {
        List<Demande> demandes = demandeService.getAll();
        ModelAndView mv = new ModelAndView("/Demandes/liste");

        List<Client> clients = new ArrayList<>();
        for(Demande d : demandes) {
            Client c = clientService.getById(d.getIdClient());
            clients.add(c);
        }

        List<Commune> communes = new ArrayList<>();
        for(Demande d : demandes) {
            Commune c = communeService.getById(d.getIdCommune());
            communes.add(c);
        }
        mv.addObject("demandes", demandes);
        mv.addObject("clients", clients);
        mv.addObject("communes", communes);
        return mv;
    }
}