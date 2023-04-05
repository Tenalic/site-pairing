package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.dto.InfosModelGenerique;
import com.tenalic.site.utils.constantes.ConstantesModel;
import com.tenalic.site.utils.constantes.ConstantesSession;
import com.tenalic.site.utils.mapper.InfosModelGeneriqueMapper;
import com.tenalic.site.utils.model.ModelUtils;

@Controller
public class Connection {

	@GetMapping(value = { "", "/", "/connection" })
	public String connectionGet(Model model, HttpSession session) {
		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);
		if (idKonami != null) {
			return "redirect:home";
		}
		return "connection";
	}

	@PostMapping("/connection")
	public String connectionPost(@RequestParam(value = "idKonami", required = true) String idKonami, Model model,
			HttpSession session) {
		session.setAttribute(ConstantesSession.ID_KONAMI, idKonami);

		model = ModelUtils.setAttributeGenerique(model, InfosModelGeneriqueMapper.mapInfosModelGenerique(idKonami));
		
		return "redirect:home";
	}

}
