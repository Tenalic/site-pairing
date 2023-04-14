package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.service.AdminService;
import com.tenalic.site.service.JoueurService;
import com.tenalic.site.utils.constantes.ConstantesModel;
import com.tenalic.site.utils.constantes.ConstantesSession;
import com.tenalic.site.utils.mapper.InfosModelGeneriqueMapper;
import com.tenalic.site.utils.model.ModelUtils;

@Controller
public class ConnexionRessource {

	@Autowired
	private AdminService adminService;

	@Autowired
	private JoueurService joueurService;

	@GetMapping(value = { "", "/", "/connection" })
	public String connexionGet(Model model, HttpSession session) {
		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);
		if (idKonami != null) {
			return "redirect:home";
		}
		return "connection";
	}

	@PostMapping("/connection")
	public String connexionPost(@RequestParam(value = "idKonami", required = true) String idKonami, Model model,
			HttpSession session) {

		String messageErreur = joueurService.verifierCossy(idKonami);

		if (messageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, messageErreur);
			return "connection";
		}

		session.setAttribute(ConstantesSession.ID_KONAMI, idKonami);

		model = ModelUtils.setAttributeGenerique(model, InfosModelGeneriqueMapper.mapInfosModelGenerique(idKonami));

		return "redirect:home";
	}

	@GetMapping(value = "/connectionAdmin")
	public String connexionAdmin(Model model, HttpSession session) {
		return "connectionAdmin";
	}

	@PostMapping("/connectionAdmin")
	public String connexionAdminPost(@RequestParam(value = "nameAdmin", required = true) String nameAdmin,
			@RequestParam(value = "paswwordAdmin", required = true) String paswwordAdmin, Model model,
			HttpSession session) {

		String messageErreur = adminService.connectionAdmin(nameAdmin, paswwordAdmin);

		if (messageErreur != null) {
			model.addAttribute(ConstantesModel.ERREUR, messageErreur);
			return "connectionAdmin";
		}

		session.setAttribute(ConstantesSession.NAME_ADMIN, nameAdmin);
		session.setAttribute(ConstantesSession.MOT_DE_PASSE_ADMIN, paswwordAdmin);

		model.addAttribute(ConstantesModel.NOM_ADMIN, nameAdmin);

		return "redirect:ecranPairingAdmin";
	}

}
