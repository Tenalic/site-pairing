package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tenalic.site.utils.Utils;

@Controller
public class Pairing {

	@GetMapping("/pairingAdmin")
	public String pairingGet(Model model, HttpSession session) {
		String redictection = Utils.estConnecte(session);

		if (redictection != null) {
			return redictection;
		}

		return "initPairing";
	}
	
	@PostMapping("/saisirPairing")
	public String pairingPost(Model model, HttpSession session) {
		String redictection = Utils.estConnecte(session);

		if (redictection != null) {
			return redictection;
		}
		
		

		return "initPairing";
	}

}
