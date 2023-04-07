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
import com.tenalic.site.utils.constantes.ConstantesModel;

@Controller
public class PairingRessource {

	@Autowired
	private AdminService adminService;

	@Autowired
	private PairingService pairingService;

	@GetMapping("/pairingAdmin")
	public String pairingGet(Model model, HttpSession session) {
		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		return "initPairing";
	}

	@PostMapping("/saisirPairing")
	public String pairingPost(Model model, HttpSession session,
			@RequestParam(value = "pairing", required = true) String pairingInfos) {

		String mesageErreur = adminService.verificationConnectionAdmin(session);

		if (mesageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
			return "redirect:connectionAdmin";
		}

		try {
			pairingService.creerPairing(pairingInfos.replaceAll("[\r\n]+", ";"));
		} catch (Exception e) {
			mesageErreur = e.toString();
			model.addAttribute(ConstantesModel.ERREUR, mesageErreur);
		}

		return "initPairing";
	}
	

}
