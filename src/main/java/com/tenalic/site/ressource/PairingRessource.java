package com.tenalic.site.ressource;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.dto.tournoi.Round;
import com.tenalic.site.dto.tournoi.Tournoi;
import com.tenalic.site.service.AdminService;
import com.tenalic.site.service.PairingService;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.constantes.ConstanteMessageErreur;
import com.tenalic.site.utils.constantes.ConstantesModel;

@Controller
public class PairingRessource {

	@Autowired
	private AdminService adminService;

	@Autowired
	private PairingService pairingService;

	@Autowired
	private TournoiServiceInterface tournoiServiceInterface;

	@GetMapping("/ecranPairingAdmin")
	public String ecranPairingAdminGet(Model model, HttpSession session) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		Tournoi tournoi = tournoiServiceInterface.getTournoi();

		if (tournoi.getIdTournoi() != 0) {
			model.addAttribute(ConstantesModel.NUMERO_ROUND, tournoi.getRoundActuelle() + 1);
		}

		return "initPairing";
	}

	@PostMapping("/creerNouvelleRound")
	public String creerNouvelleRound(Model model, HttpSession session,
			@RequestParam(value = "pairing", required = true) String pairingInfos,
			@RequestParam(value = "force") String force) {

		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		try {
			if (force == null || "non".equals(force)) {
				if (!pairingService.toutLesResultatSontRemplis()) {
					model.addAttribute(ConstantesModel.ERREUR, ConstanteMessageErreur.MANQUE_RESULTAT);
					return "initPairing";
				}
			}
			List<Round> listeRound = pairingService.creerPairing(pairingInfos.replaceAll("[\r\n]+", ";"));
			pairingService.verifierBye(listeRound);
		} catch (Exception e) {
			e.printStackTrace();
			mesageErreur = e.toString();
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
		}

		return "redirect:ecranPairingAdmin";
	}

}
