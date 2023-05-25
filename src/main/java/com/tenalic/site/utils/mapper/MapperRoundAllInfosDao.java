package com.tenalic.site.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tenalic.site.dao.object.RoundAllInfosDao;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Penalite;
import com.tenalic.site.dto.tournoi.Role;
import com.tenalic.site.dto.tournoi.Round;

public class MapperRoundAllInfosDao {

	public static List<Round> mapRound(List<RoundAllInfosDao> listRoundDao) {
		List<Round> listRound = new ArrayList<>();
		Round round;
		for (RoundAllInfosDao roundDao : listRoundDao) {
			round = new Round();
			if (roundDao != null) {
				round.setDuelFini(roundDao.getDuelFini());
				round.setNumeroRound(roundDao.getNumeroRound());
				round.setNumeroTable(roundDao.getNumeroTable());
				round.setTempsSupplementaire(roundDao.getTempsSupplementaire());
				round.setWinner(roundDao.getWinnerName());
				round.setJoueur1(mapJoueur1(roundDao));
				round.setJoueur2(mapJoueur2(roundDao));
				round.setIdRound(roundDao.getIdTournoi());
				round.setWinnerJoueurId(roundDao.getWinnerJoueurId());
			}
			listRound.add(round);
		}
		return listRound;
	}

	public static Joueur mapJoueur1(RoundAllInfosDao allInfosDao) {
		Joueur joueur = new Joueur();
		if (allInfosDao != null) {
			joueur.setCossy(allInfosDao.getCossy_j1());
			joueur.setListePenatite(new ArrayList<Penalite>());
			joueur.setNom(allInfosDao.getNom_j1());
			joueur.setPoint(Optional.ofNullable(allInfosDao).map(RoundAllInfosDao::getPoint_j1).orElse(0));
			joueur.setPrenom(allInfosDao.getPrenom_j1());
			joueur.setRole(new Role());
			joueur.setDrop(Optional.ofNullable(allInfosDao).map(RoundAllInfosDao::isDrop_j1).orElse(false));
			joueur.setId(String.valueOf(allInfosDao.getIdJoueur1()));
		}
		return joueur;
	}

	public static Joueur mapJoueur2(RoundAllInfosDao allInfosDao) {
		Joueur joueur = new Joueur();
		if (allInfosDao != null) {
			joueur.setCossy(allInfosDao.getCossy_j2());
			joueur.setListePenatite(new ArrayList<Penalite>());
			joueur.setNom(allInfosDao.getNom_j2());
			joueur.setPoint(Optional.ofNullable(allInfosDao).map(RoundAllInfosDao::getPoint_j2).orElse(0));
			Optional.ofNullable(allInfosDao).map(RoundAllInfosDao::isDrop_j2).orElse(false);
			joueur.setPrenom(allInfosDao.getPrenom_j2());
			joueur.setRole(new Role());
			joueur.setDrop(Optional.ofNullable(allInfosDao).map(RoundAllInfosDao::isDrop_j2).orElse(false));
			joueur.setId(String.valueOf(allInfosDao.getIdJoueur2()));
		}
		return joueur;
	}

}
