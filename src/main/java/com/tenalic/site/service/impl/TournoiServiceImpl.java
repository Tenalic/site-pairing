package com.tenalic.site.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenalic.site.dao.FakeBaseDeDonnee;
import com.tenalic.site.dao.repository.JoueurRepo;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Tournoi;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.Utils;
import com.tenalic.site.utils.mapper.MapperJoueur;

@Service
public class TournoiServiceImpl implements TournoiServiceInterface {

	private static final String LISTE_NOUVEAU_JOUEUR = "LISTE_NOUVEAU_JOUEUR";

	private static final String LISTE_JOUEUR = "LISTE_JOUEUR";

	@Autowired
	private JoueurRepo joueurRepo;

	@Override
	/**
	 * infos : prenom ; nom ; cossy ; prenom ; nom ; cossy ; [...]
	 */
	public List<Joueur> creerTournoi(String infos) {
		return creerTournoiJoueur(infos);
	}

	private List<Joueur> creerTournoiJoueur(String infos) {
		List<String> listeInfosFormate;
		Map<String, List<Joueur>> mapListeJoueur;
		try {
			listeInfosFormate = Arrays.asList(infos.split(";"));
			mapListeJoueur = creeListJoueur(listeInfosFormate);
			sauvegarderListeJoueurs(mapListeJoueur.get(LISTE_NOUVEAU_JOUEUR));

		} catch (Exception e) {
			throw e;
		}
		return mapListeJoueur.get(LISTE_JOUEUR);
	}

	private Map<String, List<Joueur>> creeListJoueur(List<String> listeInfosFormate) {
		List<Joueur> joueurList = getListJoueur();
		List<Joueur> nouveauJoueur = new ArrayList<Joueur>();
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
					nouveauJoueur.add(joueur);
				}
				count = 0;
			}
		}
		Map<String, List<Joueur>> mapListeJoueur = new HashMap<String, List<Joueur>>();
		mapListeJoueur.put(LISTE_JOUEUR, joueurList);
		mapListeJoueur.put(LISTE_NOUVEAU_JOUEUR, nouveauJoueur);
		return mapListeJoueur;
	}

	private void sauvegarderListeJoueurs(List<Joueur> listeJoueur) {
		joueurRepo.saveAll(MapperJoueur.mapListJoueurDao(listeJoueur));
	}

	public List<Joueur> getListJoueur() {
		return MapperJoueur.mapListJoueur(joueurRepo.findAll());
	}

	@Override
	public Tournoi getTournoi() {
		return FakeBaseDeDonnee.getInstanceTournoi().getTournoi();
	}

}
