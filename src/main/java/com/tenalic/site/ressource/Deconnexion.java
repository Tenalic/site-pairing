package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Deconnexion {

	@PostMapping("/deconnexion")
	public String deconnexionGet(Model model, HttpSession session) {
		model.addAttribute("provenance", "deconnexion");
		session.setAttribute("id", null);
		return "connection";
	}

}
