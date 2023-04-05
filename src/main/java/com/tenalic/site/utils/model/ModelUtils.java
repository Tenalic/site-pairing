package com.tenalic.site.utils.model;

import org.springframework.ui.Model;

import com.tenalic.site.dto.InfosModelGenerique;
import com.tenalic.site.utils.constantes.ConstantesModel;

public class ModelUtils {

	public static Model setAttributeGenerique(Model model, InfosModelGenerique infosModelGenerique) {
		model.addAttribute(ConstantesModel.ID_KONAMI, infosModelGenerique.getIdKonami());
		return model;
	}

}
