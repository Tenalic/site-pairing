package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.utils.ConstantesModel;
import com.tenalic.site.utils.ConstantesSession;

@Controller
public class Connection {

	@GetMapping(value = { "", "/", "/connection" })
	public String connectionGet(Model model, HttpSession session) {
		model.addAttribute(ConstantesModel.PROVENANCE, "connectionGet");
		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);
		if (idKonami != null) {
			model.addAttribute(ConstantesModel.ID_KONAMI, idKonami);
			return "redirect:home";
		}
		return "connection";
	}

	@PostMapping("/connection")
	public String connectionPost(@RequestParam(value = "idKonami", required = true) String idKonami, Model model,
			HttpSession session) {
		model.addAttribute(ConstantesModel.PROVENANCE, "connectionPost");
		session.setAttribute(ConstantesSession.ID_KONAMI, idKonami);
		model.addAttribute(ConstantesModel.ID_KONAMI, idKonami);
		return "redirect:home";
	}

}
