package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tenalic.site.utils.ConstantesModel;
import com.tenalic.site.utils.ConstantesSession;

@Controller
public class Home {
	
	@GetMapping("/home")
	public String homeGet(Model model, HttpSession session) {
		model.addAttribute(ConstantesModel.PROVENANCE, "home");
		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);
		model.addAttribute(ConstantesModel.ID_KONAMI, idKonami);
		return "home";
	}

}
