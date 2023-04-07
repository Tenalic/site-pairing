package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenalic.site.utils.constantes.ConstantesSession;

@Controller
public class Deconnexion {

	@RequestMapping("/deconnexion")
	public String deconnexionGet(Model model, HttpSession session) {
		session.setAttribute(ConstantesSession.ID_KONAMI, null);
		return "redirect:connection";
	}

	@RequestMapping("/deconnexionAdmin")
	public String deconnexionAdminGet(Model model, HttpSession session) {
		session.setAttribute(ConstantesSession.NAME_ADMIN, null);
		session.setAttribute(ConstantesSession.MOT_DE_PASSE_ADMIN, null);
		return "redirect:connectionAdmin";
	}

}
