package com.tenalic.site.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tenalic.site.dao.object.RoundDao;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Round;

public class MapperRound {

	public static List<Round> mapListRound(List<RoundDao> listRoundDao) {
		List<Round> listRound = new ArrayList<>();
		return listRound;
	}

	public static List<RoundDao> mapListRoundDao(List<Round> listRound, int idRound, Joueur joueurWinner) {
		List<RoundDao> listRoundDao = new ArrayList<>();
		for (Round round : listRound) {
			listRoundDao.add(mapRoundDao(round, idRound, joueurWinner));
		}
		return listRoundDao;
	}

	public static RoundDao mapRoundDao(Round round, int idTournoi, Joueur joueurWinner) {
		RoundDao roundDao = new RoundDao();
		if (round != null) {
			roundDao.setDuelFini(round.isDuelFini());
			String id = Optional.of(round).map(Round::getJoueur1).map(Joueur::getId).orElse(null);
			if (id != null)
				roundDao.setIdJoueur1(Integer.parseInt(id));
			id = Optional.of(round).map(Round::getJoueur2).map(Joueur::getId).orElse(null);
			if (id != null)
				roundDao.setIdJoueur2(Integer.parseInt(id));
			roundDao.setIdRound(round.getIdRound());
			roundDao.setIdTournoi(idTournoi);
			roundDao.setNumeroRound(round.getNumeroRound());
			roundDao.setNumeroTable(round.getNumeroTable());
			roundDao.setTempsSupplementaire(round.getTempsSupplementaire());
			if (joueurWinner != null) {
				roundDao.setWinnerCossy(joueurWinner.getCossy());
				if (joueurWinner.getId() != null)
					roundDao.setWinnerJoueurId(Integer.parseInt(joueurWinner.getId()));
				roundDao.setWinnerName(
						joueurWinner.getPrenom() + " " + joueurWinner.getNom() + " " + joueurWinner.getCossy());
			}
		}
		return roundDao;
	}

}
