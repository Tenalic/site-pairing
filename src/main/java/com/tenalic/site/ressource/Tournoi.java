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
public class Tournoi {

	@Autowired
	private TournoiServiceInterface tournoiServiceInterface;

	@Autowired
	private AdminService adminService;

	@PostMapping("/creerTournoi")
	public String creerTournoi(Model model, HttpSession session,
			@RequestParam(value = "infosJoueur", required = true) String infosJoueur) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}
		if (infosJoueur == null || "".equals(infosJoueur)) {
			model.addAttribute(ConstantesModel.ERREUR, ConstanteMessageErreur.CHAMP_VIDE);
			return "initPairing";
		}
		tournoiServiceInterface.creerTournoi(infosJoueur.replaceAll("[\r\n]+", ";"));
		return "initPairing";
	}

	@GetMapping("/creerTournoi")
	public String getPageSaisie(Model model, HttpSession session) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}
		return "initPairing";
	}

	@GetMapping("/listeJoueur")
	public String getListeJoueur(Model model, HttpSession session) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}
		model.addAttribute(ConstantesModel.TOURNOI, tournoiServiceInterface.getListJoueur());
		return "listeJoueur";
	}

}
