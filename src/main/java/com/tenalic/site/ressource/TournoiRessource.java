package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.service.AdminService;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.constantes.ConstanteMessageErreur;
import com.tenalic.site.utils.constantes.ConstantesModel;

@Controller
public class TournoiRessource {

	private static String CREER = "1";

	@Autowired
	private TournoiServiceInterface tournoiServiceInterface;

	@Autowired
	private AdminService adminService;

	@PostMapping("/creerTournoi")
	public String creerTournoi(Model model, HttpSession session,
			@RequestParam(value = "infosJoueur", required = true) String infosJoueur,
			@RequestParam(value = "nouveauTournoi", required = true) String nouveauTournoi) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}
		if (infosJoueur == null || "".equals(infosJoueur)) {
			model.addAttribute(ConstantesModel.ERREUR, ConstanteMessageErreur.CHAMP_VIDE);
			return "initPairing";
		}
		if (CREER.equals(nouveauTournoi)) {
			tournoiServiceInterface.creerTournoi(infosJoueur.replaceAll("[\r\n]+", ";"));
		} else {
			tournoiServiceInterface.ajouterJoueurDansTournoi(infosJoueur.replaceAll("[\r\n]+", ";"));
		}
		return "redirect:ecranPairingAdmin";
	}

	@GetMapping("/creerTournoi")
	public String getPageSaisie(Model model, HttpSession session) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}
		return "redirect:ecranPairingAdmin";
	}

	@GetMapping("/listeJoueur")
	public String getListeJoueur(Model model, HttpSession session) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}
		model.addAttribute(ConstantesModel.TOURNOI,
				tournoiServiceInterface.getListJoueurByIdTournoi(tournoiServiceInterface.getTournoi().getIdTournoi()));
		return "listeJoueur";
	}

}
