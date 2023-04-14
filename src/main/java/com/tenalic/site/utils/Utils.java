package com.tenalic.site.utils;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.tenalic.site.dto.tournoi.Joueur;
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
			Double.parseDouble(idkonami);
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

	public static String estConnecteAdmin(HttpSession session) {
		String nameAdmin = (String) session.getAttribute(ConstantesSession.NAME_ADMIN);

		if (nameAdmin == null) {
			return "redirect:connectionAdmin";
		}
		return null;
	}

	public static boolean listeContienJoueur(List<Joueur> listeJoueur, Joueur joueur) {
		if (joueur == null || joueur.getCossy() == null) {
			return false;
		}
		for (Joueur j : listeJoueur) {
			if (j.getCossy().equals(joueur.getCossy())) {
				return true;
			}
		}
		return false;
	}

}
