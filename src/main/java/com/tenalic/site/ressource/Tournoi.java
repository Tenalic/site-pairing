package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.constantes.ConstanteMessageErreur;
import com.tenalic.site.utils.constantes.ConstantesModel;

@Controller
public class Tournoi {

	@Autowired
	private TournoiServiceInterface tournoiServiceInterface;

	@PostMapping("/creerTournoi")
	public String creerTournoi(Model model, HttpSession session,
			@RequestParam(value = "infosJoueur", required = true) String infosJoueur) {
		if (infosJoueur == null || "".equals(infosJoueur)) {
			model.addAttribute(ConstantesModel.ERREUR, ConstanteMessageErreur.CHAMP_VIDE);
			return "initPairing";
		}
		tournoiServiceInterface.creerTournoi(infosJoueur.replaceAll("[\r\n]+", ";"));
		return "initPairing";
	}

	@GetMapping("/creerTournoi")
	public String getPageSaisie(Model model, HttpSession session) {
		return "initPairing";
	}

}
