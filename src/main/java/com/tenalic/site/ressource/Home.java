package com.tenalic.site.ressource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenalic.site.service.PairingService;
import com.tenalic.site.service.RoundService;
import com.tenalic.site.utils.Utils;
import com.tenalic.site.utils.constantes.Constantes;
import com.tenalic.site.utils.constantes.ConstantesModel;
import com.tenalic.site.utils.constantes.ConstantesSession;
import com.tenalic.site.utils.mapper.InfosModelGeneriqueMapper;
import com.tenalic.site.utils.model.ModelUtils;

@Controller
public class Home {

	@Autowired
	private PairingService pairingService;

	@Autowired
	private RoundService roundService;

	@GetMapping("/home")
	public String homeGet(Model model, HttpSession session) {
		String redictection = Utils.estConnecte(session);

		if (redictection != null) {
			return redictection;
		}

		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);

		try {
			model.addAttribute(ConstantesModel.LIST_ROUND, roundService.recupererInfosJoueursRound(idKonami));
		} catch (Exception e) {
			model.addAttribute(ConstantesModel.ERREUR, e.toString());
			e.printStackTrace();
			return "home";
		}

		model = ModelUtils.setAttributeGenerique(model, InfosModelGeneriqueMapper.mapInfosModelGenerique(idKonami));

		return "home";
	}

	@PostMapping("/saisirWinner")
	public String saisirWinner(Model model, HttpSession session,
			@RequestParam(value = "winner", required = true) String cossyWinner,
			@RequestParam(value = "table", required = true) String table,
			@RequestParam(value = "round", required = true) String round) {

		String redictection = Utils.estConnecte(session);

		if (redictection != null) {
			return redictection;
		}

		try {
			pairingService.saisirResultatMatch(Integer.parseInt(table), Integer.parseInt(round), cossyWinner,
					Constantes.SAISIR);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ConstantesModel.ERREUR, e.toString());
		}

		return "redirect:home";
	}

}
