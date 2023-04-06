package com.tenalic.site.utils;

import com.tenalic.site.utils.constantes.ConstanteMessageErreur;

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

}
