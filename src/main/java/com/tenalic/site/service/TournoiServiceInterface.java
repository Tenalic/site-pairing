package com.tenalic.site.service;

import java.util.List;

import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Tournoi;

public interface TournoiServiceInterface {

	List<Joueur> creerTournoi(String infos);

	List<Joueur> ajouterJoueurDansTournoi(String infos);

	Tournoi getTournoi();

	List<Joueur> getListJoueur();

	List<Joueur> getListJoueurByIdTournoi(int idTournoi);

}
