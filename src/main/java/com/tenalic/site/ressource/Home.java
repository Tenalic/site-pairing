package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tenalic.site.service.PairingService;
import com.tenalic.site.utils.Utils;
import com.tenalic.site.utils.constantes.ConstantesModel;
import com.tenalic.site.utils.constantes.ConstantesSession;
import com.tenalic.site.utils.mapper.InfosModelGeneriqueMapper;
import com.tenalic.site.utils.model.ModelUtils;

@Controller
public class Home {

	@Autowired
	private PairingService pairingService;

	@GetMapping("/home")
	public String homeGet(Model model, HttpSession session) {
		String redictection = Utils.estConnecte(session);

		if (redictection != null) {
			return redictection;
		}

		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);

		try {
			pairingService.recupererInfosJoueursRound(idKonami);
			model.addAttribute(ConstantesModel.LIST_ROUND, pairingService.recupererInfosJoueursRound(idKonami));
		} catch (Exception e) {
			model.addAttribute(ConstantesModel.ERREUR, e.toString());
			e.printStackTrace();
			return "home";
		}

		model = ModelUtils.setAttributeGenerique(model, InfosModelGeneriqueMapper.mapInfosModelGenerique(idKonami));

		return "home";
	}

}
