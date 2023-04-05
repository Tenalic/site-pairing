package com.tenalic.site.utils.mapper;

import com.tenalic.site.dto.InfosModelGenerique;

public class InfosModelGeneriqueMapper {

	public static InfosModelGenerique mapInfosModelGenerique(String idKonami) {
		InfosModelGenerique infosModelGenerique = new InfosModelGenerique();
		infosModelGenerique.setIdKonami(idKonami);
		return infosModelGenerique;
	}

}
