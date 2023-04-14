package com.tenalic.site.service;

import com.tenalic.site.dto.tournoi.Joueur;

public interface JoueurService {

	Joueur recupererJoueur(String cossy, int idTournoi);

	String verifierCossy(String cossy);

}
