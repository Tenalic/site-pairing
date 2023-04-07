package com.tenalic.site.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tenalic.site.dao.FakeBaseDeDonnee;
import com.tenalic.site.dto.tournoi.Joueur;
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
		List<String> listeInfosFormate;
		try {
			listeInfosFormate = Arrays.asList(infos.split(";"));
		} catch (Exception e) {
			throw e;
		}
		tournoi.setListeJoueur(creeListJoueur(listeInfosFormate));
		FakeBaseDeDonnee.getInstanceTournoi().setTournoi(tournoi);
	}

	private List<Joueur> creeListJoueur(List<String> listeInfosFormate) {
		List<Joueur> joueurList = new ArrayList<>();
		int count = 0;
		Joueur joueur = null;
		for (String info : listeInfosFormate) {
			if (count == 0) {
				joueur = new Joueur();
			}
			switch (count) {
			case 0:
				joueur.setCossy(info);
				break;
			case 1:
				joueur.setNom(info);
				break;
			case 2:
				joueur.setPrenom(info);
				break;
			}
			count++;
			if (count == 3) {
				joueurList.add(joueur);
				count = 0;
			}
		}
		return joueurList;
	}

	@Override
	public Tournoi getTournoi() {
		return FakeBaseDeDonnee.getInstanceTournoi().getTournoi();
	}

}
