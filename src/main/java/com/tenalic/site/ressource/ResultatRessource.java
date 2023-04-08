package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.service.AdminService;
import com.tenalic.site.service.PairingService;
import com.tenalic.site.service.ResultatService;
import com.tenalic.site.utils.constantes.Constantes;
import com.tenalic.site.utils.constantes.ConstantesModel;

@Controller
public class ResultatRessource {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ResultatService resultatService;

	@Autowired
	private PairingService pairingService;

	@GetMapping("/resultat")
	public String resultatGet(Model model, HttpSession session) {

		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		try {
			model.addAttribute(ConstantesModel.RESULTAT_ROUND_NUMERO, resultatService.getListRound());
		} catch (Exception e) {
			model.addAttribute(ConstantesModel.ERREUR, e);
		}

		return "resultat";
	}

	@PostMapping("/resultat/consulter")
	public String consulterResultat(Model model, HttpSession session,
			@RequestParam(value = "numeroRound") String roundNumero) {

		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		try {
			model.addAttribute(ConstantesModel.RESULTAT_ROUND_NUMERO, resultatService.getListRound());
			model.addAttribute(ConstantesModel.LIST_ROUND, resultatService.getListRoundByNumeroRound(roundNumero));
			model.addAttribute(ConstantesModel.NUMERO_ROUND, "Affichage de la round " + roundNumero);
		} catch (Exception e) {
			model.addAttribute(ConstantesModel.ERREUR, e);
		}

		return "resultat";
	}

	@PostMapping("/modifierWinner")
	public String saisirWinner(Model model, HttpSession session,
			@RequestParam(value = "winner", required = true) String cossyWinner) {

		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		try {
			pairingService.saisirResultatMatch(cossyWinner, Constantes.MODIFIER);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ConstantesModel.ERREUR, e.toString());
		}

		return "redirect:resultat";
	}

}
