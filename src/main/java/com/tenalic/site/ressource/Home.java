package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tenalic.site.utils.Utils;
import com.tenalic.site.utils.constantes.ConstantesSession;
import com.tenalic.site.utils.mapper.InfosModelGeneriqueMapper;
import com.tenalic.site.utils.model.ModelUtils;

@Controller
public class Home {

	@GetMapping("/home")
	public String homeGet(Model model, HttpSession session) {
		String redictection = Utils.estConnecte(session);

		if (redictection != null) {
			return redictection;
		}
		
		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);

		model = ModelUtils.setAttributeGenerique(model, InfosModelGeneriqueMapper.mapInfosModelGenerique(idKonami));

		return "home";
	}

}
