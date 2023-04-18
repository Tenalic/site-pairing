package com.tenalic.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenalic.site.dao.object.JoueurDao;
import com.tenalic.site.dao.repository.JoueurRepo;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.service.JoueurService;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.Utils;
import com.tenalic.site.utils.constantes.ConstanteMessageErreur;
import com.tenalic.site.utils.mapper.MapperJoueur;

@Service
public class JoueurServiceImpl implements JoueurService {

	@Autowired
	private JoueurRepo joueurRepo;

	@Autowired
	private TournoiServiceInterface tournoiServiceInterface;

	@Override
	public Joueur recupererJoueur(String cossy, int idTournoi) {
		return MapperJoueur.mapJoueur(joueurRepo.findByCossyAndIdTournoi(cossy, idTournoi).orElse(null));
	}

	@Override
	public String verifierCossy(String cossy) {
		String messageErreur = Utils.verifierIdKonami(cossy);
		if (messageErreur == null
				&& recupererJoueur(cossy, tournoiServiceInterface.getTournoi().getIdTournoi()).getCossy() == null) {
			messageErreur = ConstanteMessageErreur.COSSY_NON_TROUVE;
		}
		return messageErreur;
	}

	@Override
	public void saveJoueur(Joueur joueur, int idTournoi) {

	}

	@Override
	public void updatePointThemSaveJoueur(Joueur joueur, int idTournoi, int nombrePoint) {
		JoueurDao joueurDao = joueurRepo.findByCossyAndIdTournoi(joueur.getCossy(), idTournoi).orElse(null);
		joueurDao.setPoint(nombrePoint);
		joueurRepo.save(joueurDao);
	}

	@Override
	public Joueur recupererJoueurParId(Integer id) {
		return MapperJoueur.mapJoueur(joueurRepo.findById(id).orElse(null));
	}

}
