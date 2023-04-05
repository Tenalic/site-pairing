package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.tenalic.site.utils.constantes.ConstantesModel;
import com.tenalic.site.utils.constantes.ConstantesSession;

@Controller
public class Deconnexion {

	@PostMapping("/deconnexion")
	public String deconnexionGet(Model model, HttpSession session) {
		model.addAttribute(ConstantesModel.PROVENANCE, "deconnexion");
		session.setAttribute(ConstantesSession.ID_KONAMI, null);
		return "redirect:connection";
	}

}
