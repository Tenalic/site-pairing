package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Connection {

	@GetMapping(value = { "", "/", "/connection" })
	public String connectionGet(Model model, HttpSession session) {
		model.addAttribute("provenance", "connectionGet");
		String id = (String) session.getAttribute("id");
		if (id != null) {
			model.addAttribute("id", id);
		} else {
			model.addAttribute("id", "null");
		}
		return "connection";
	}

	@PostMapping("/connection")
	public String connectionPost(@RequestParam(value = "idKonami", required = true) String idKonami, Model model,
			HttpSession session) {
		model.addAttribute("provenance", "connectionPost");
		session.setAttribute("id", idKonami);
		model.addAttribute("id", idKonami);
		return "home";
	}

}
