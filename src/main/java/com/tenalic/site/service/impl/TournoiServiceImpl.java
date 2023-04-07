package com.tenalic.site.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tenalic.site.dao.FakeBaseDeDonnee;
import com.tenalic.site.dto.tournoi.Tournoi;
import com.tenalic.site.service.TournoiServiceInterface;

@Service
public class TournoiServiceImpl implements TournoiServiceInterface {

	@Override
	/**
	 * infos : cossy ; nom ; prenom
	 */
	public String creerTournoi(String infos) {
		try {
			creerTournoiJoueur(infos);
		} catch (Exception e) {
			return "une erreur est survenue lors de la création du tournoi";
		}
		return null;
	}

	private void creerTournoiJoueur(String infos) {
		Tournoi tournoi = new Tournoi();
		List<String> listeInfosFormaté;
		try {
			listeInfosFormaté = Arrays.asList(infos.split(";"));
		} catch (Exception e) {
			throw e;
		}
		System.out.println(listeInfosFormaté);
		FakeBaseDeDonnee.getInstanceTournoi().setTournoi(tournoi);
	}

	@Override
	public Tournoi getTournoi() {
		return FakeBaseDeDonnee.getInstanceTournoi().getTournoi();
	}

}
