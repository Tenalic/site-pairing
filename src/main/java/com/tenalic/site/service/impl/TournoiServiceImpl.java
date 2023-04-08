package com.tenalic.site.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tenalic.site.dao.FakeBaseDeDonnee;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Tournoi;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.Utils;

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
		Tournoi tournoi = Optional.ofNullable(FakeBaseDeDonnee.getInstanceTournoi().getTournoi()).orElse(new Tournoi());
		List<String> listeInfosFormate;
		try {
			listeInfosFormate = Arrays.asList(infos.split(";"));
		} catch (Exception e) {
			throw e;
		}
		tournoi.setListeJoueur(creeListJoueur(listeInfosFormate, tournoi));
		FakeBaseDeDonnee.getInstanceTournoi().setTournoi(tournoi);
	}

	private List<Joueur> creeListJoueur(List<String> listeInfosFormate, Tournoi tournoi) {
		List<Joueur> joueurList = Optional.ofNullable(tournoi.getListeJoueur()).orElse(new ArrayList<Joueur>());
		int count = 0;
		Joueur joueur = null;
		for (String info : listeInfosFormate) {
			if (count == 0) {
				joueur = new Joueur();
			}
			switch (count) {
			case 0:
				joueur.setPrenom(info);
				break;
			case 1:
				joueur.setNom(info);
				break;
			case 2:
				joueur.setCossy(info);
				break;
			}
			count++;
			if (count == 3) {
				if (!Utils.listeContienJoueur(joueurList, joueur)) {
					joueurList.add(joueur);
				}
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
