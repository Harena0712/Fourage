package com.fourage.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fourage.model.*;
import com.fourage.service.*;
import com.fourage.cache.*;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DevisController {

    @Autowired
    private DemandeService demandeService;
    @Autowired
    private StatutService statutService;
    @Autowired
    private DevisService devisService;
    @Autowired
    private StatutDemandeService statutDemandeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private DevisDetailService devisDetailService;
    @Autowired
    private StatutCache statutCache;

    public Map<String, Integer> getStatutMap() {
        Map<String, Integer> statutMap = new HashMap<>();
        List<Statut> statuts = statutService.getAll();
        for (Statut statut : statuts) {
            statutMap.put(statut.getSigle(), statut.getId());
        }
        return statutMap;
    }

    @GetMapping("/devis/formulaire")
    public ModelAndView formulaire() {
        List<Demande> demandes = demandeService.getAll();
        List<Type> types = typeService.getAll();
        ModelAndView mv = new ModelAndView("Devis/formulaire");
        mv.addObject("demandes", demandes);
        mv.addObject("types", types);
        return mv;
    }

    @GetMapping("/devis/lister")
    public ModelAndView lister() {
        List<Devis> devis = devisService.getAll();
        List<Client> clients = clientService.getAll();
        List<Demande> demandes = demandeService.getAll();
        List<Type> types = typeService.getAll();
        List<DevisDetail> devisDetails = devisDetailService.getAll();
        ModelAndView mv = new ModelAndView("Devis/liste");
        mv.addObject("devis", devis);
        mv.addObject("clients", clients);
        mv.addObject("demandes", demandes);
        mv.addObject("types", types);
        mv.addObject("devisDetails", devisDetails);
        return mv;
    }

    @PostMapping("/devis/infoDemande")
    @ResponseBody
    public Map<String, Object> infoDemande(@RequestParam("idDemande") int idDemande) {

        Demande demande = demandeService.getById(idDemande);
        Client client = clientService.getById(demande.getIdClient());

        Map<String, Object> response = new HashMap<>();

        if(demande != null) {
            response.put("success", true);
            response.put("lieu", demande.getLieu());
            response.put("date", demande.getDaty());
            response.put("reference", demande.getReference());
            response.put("client", client.getNom());
        }

        return response;
    }

    @PostMapping("/devis/ajouter")
    public ModelAndView ajouter(
            @RequestParam("idDemande") int idDemande,
            @RequestParam("desc") String desc,
            @RequestParam("idType") int idType,
            @RequestParam("daty") String daty,
            HttpServletRequest request) {

        Map<Integer, String> typeMap = typeService.getTypeMap();
        Map<String, Integer> statutMap = getStatutMap();

        String sigle = "";
        int idStatut = 0;

        for (Integer cle : typeMap.keySet()) {
            if (cle == idType) {
                sigle = typeMap.get(cle);
            }
        }

        // for (String cle : statutMap.keySet()) {
        //     if (cle.equals(sigle)) {
        //         idStatut = statutMap.get(cle);
        //     }
        // }

        if (sigle != null && !sigle.isEmpty()) {
            idStatut = statutMap.get(sigle);
        }

        LocalDateTime dateDevis = LocalDateTime.parse(daty);

        Devis devis = new Devis(idDemande, idType, desc, dateDevis);
        devisService.save(devis);

        StatutDemande statutDemande = new StatutDemande();
        statutDemande.setIdDemande(idDemande);
        statutDemande.setIdStatut(idStatut);
        statutDemande.setDaty(dateDevis);

        statutDemandeService.save(statutDemande);

        String[] libelles = request.getParameterValues("libelle[]");
        String[] qnts = request.getParameterValues("qnt[]");
        String[] PUs = request.getParameterValues("PU[]");

        if (libelles != null) {
            for (int i = 0; i < libelles.length; i++) {
                String libelle = libelles[i];
                int qnt = 0;
                double PU = 0.0;

                try {
                    if (qnts != null && i < qnts.length && qnts[i] != null && !qnts[i].isEmpty()) {
                        qnt = Integer.parseInt(qnts[i]);
                    }
                } catch (NumberFormatException e) {
                    qnt = 0;
                }

                try {
                    if (PUs != null && i < PUs.length && PUs[i] != null && !PUs[i].isEmpty()) {
                        PU = Double.parseDouble(PUs[i]);
                    }
                } catch (NumberFormatException e) {
                    PU = 0.0;
                }

                if (libelle != null && !libelle.trim().isEmpty()) {
                    DevisDetail detail = new DevisDetail(devis.getId(), libelle.trim(), qnt, PU);
                    devisDetailService.save(detail);
                }
            }
        }

        List<Demande> demandes = demandeService.getAll();
        List<Type> types = typeService.getAll();
        ModelAndView mv = new ModelAndView("Devis/formulaire");
        mv.addObject("demandes", demandes);
        mv.addObject("types", types);
        mv.addObject("succes", "Devis ajouté avec succès");
        return mv;
    }
}
