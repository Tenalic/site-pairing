package com.tenalic.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenalic.site.dao.repository.JoueurRepo;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.service.JoueurService;
import com.tenalic.site.utils.mapper.MapperJoueur;

@Service
public class JoueurServiceImpl implements JoueurService {

	@Autowired
	private JoueurRepo joueurRepo;

	@Override
	public Joueur recupererJoueur(String cossy, int idTournoi) {
		return MapperJoueur.mapJoueur(joueurRepo.findByCossyAndIdTournoi(cossy, idTournoi).orElse(null));
	}

}
