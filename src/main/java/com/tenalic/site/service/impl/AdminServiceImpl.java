package com.tenalic.site.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tenalic.site.service.AdminService;
import com.tenalic.site.utils.constantes.ConstanteMessageErreur;
import com.tenalic.site.utils.constantes.ConstantesSession;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public String connectionAdmin(String nameAdmin, String paswwordAdmin) {
		if (ConstantesSession.NOM_ADMIN_DURE.equals(paswwordAdmin)
				&& ConstantesSession.PASSWORD_ADMIN_DURE.equals(paswwordAdmin)) {
			return null;
		}
		return ConstanteMessageErreur.IDENTIFIANT_ERRONEE;
	}

	@Override
	public String verificationConnectionAdmin(HttpSession session) {
		String mesageErreur = null;

		try {
			mesageErreur = connectionAdmin((String) session.getAttribute(ConstantesSession.NAME_ADMIN),
					(String) session.getAttribute(ConstantesSession.MOT_DE_PASSE_ADMIN));
		} catch (Exception e) {
			mesageErreur = e.toString();
		}
		return mesageErreur;
	}

}
