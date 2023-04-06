package com.tenalic.site.utils;

import javax.servlet.http.HttpSession;

import com.tenalic.site.utils.constantes.ConstanteMessageErreur;
import com.tenalic.site.utils.constantes.ConstantesSession;

public class Utils {

	public static String verifierIdKonami(String idkonami) {
		if (idkonami == null) {
			return ConstanteMessageErreur.ID_KONAMI_NULL_ERREUR;
		}
		if (idkonami.length() != 10) {
			return ConstanteMessageErreur.ID_KONAMI_MAUVAISE_TAILLE_ERREUR;
		}
		try {
			Integer.parseInt(idkonami);
		} catch (Exception e) {
			return ConstanteMessageErreur.ID_KONAMI_PAS_QUE_DES_CHIFFRE_ERREUR;
		}
		return null;
	}

	public static String estConnecte(HttpSession session) {
		String idKonami = (String) session.getAttribute(ConstantesSession.ID_KONAMI);

		if (idKonami == null) {
			return "redirect:connection";
		}
		return null;
	}

}
