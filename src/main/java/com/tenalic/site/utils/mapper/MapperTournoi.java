package com.tenalic.site.utils.mapper;

import java.util.Optional;

import com.tenalic.site.dao.object.TournoiDao;
import com.tenalic.site.dto.tournoi.Tournoi;

public class MapperTournoi {

	public static Tournoi mapTournoi(TournoiDao tournoiDao) {
		Tournoi tournoi = new Tournoi();
		tournoi.setRoundActuelle(Optional.ofNullable(tournoiDao).map(TournoiDao::getNumeroRoundActuelle).orElse(0));
		tournoi.setIdTournoi(Optional.ofNullable(tournoiDao).map(TournoiDao::getIdTournoi).orElse(0));
		return tournoi;
	}

	public static TournoiDao mapTournoiDao(Tournoi tournoi) {
		TournoiDao tournoiDao = new TournoiDao();
		tournoiDao.setNumeroRoundActuelle(tournoi.getRoundActuelle());
		tournoiDao.setIdTournoi(tournoi.getIdTournoi());
		return tournoiDao;
	}

}
