package com.tenalic.site.service;

import com.tenalic.site.dto.tournoi.Joueur;

public interface JoueurService {

	Joueur recupererJoueur(String cossy, int idTournoi);

	Joueur recupererJoueurParId(Integer integer);

	String verifierCossy(String cossy);

	void saveJoueur(Joueur joueur, int idTournoi);

	void updatePointThemSaveJoueur(Joueur joueur, int idTournoi, int nombrePoint);

}
