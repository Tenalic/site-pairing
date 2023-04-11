package com.tenalic.site.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tenalic.site.dao.object.JoueurDao;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Penalite;
import com.tenalic.site.dto.tournoi.Role;

public class MapperJoueur {

	public static List<Joueur> mapListJoueur(Iterable<JoueurDao> iterable) {
		List<Joueur> listeJoueur = new ArrayList<Joueur>();
		for (JoueurDao joueurDao : iterable) {
			listeJoueur.add(mapJoueur(joueurDao));
		}
		return listeJoueur;
	}

	public static Joueur mapJoueur(JoueurDao joueurDao) {
		Joueur joueur = new Joueur();
		if (joueurDao != null) {
			joueur.setCossy(joueurDao.getCossy());
			joueur.setDrop(Optional.of(joueurDao).map(JoueurDao::isDrop).orElse(false));
			joueur.setNom(joueurDao.getNom());
			joueur.setPoint(joueurDao.getPoint());
			joueur.setPrenom(joueurDao.getPrenom());
			joueur.setRole(new Role());
			joueur.setListePenatite(new ArrayList<Penalite>());
		}
		return joueur;
	}

	public static List<JoueurDao> mapListJoueurDao(List<Joueur> listeJoueur, int idTournoi) {
		List<JoueurDao> listeJoueurDao = new ArrayList<JoueurDao>();
		for (Joueur joueur : listeJoueur) {
			listeJoueurDao.add(mapJoueurDao(joueur, idTournoi));
		}
		return listeJoueurDao;
	}

	public static JoueurDao mapJoueurDao(Joueur joueur, int idTournoi) {
		JoueurDao joueurDao = new JoueurDao();
		if (joueur != null) {
			joueurDao.setCossy(joueur.getCossy());
			joueurDao.setDrop(Optional.of(joueur).map(Joueur::isDrop).orElse(false));
			joueurDao.setNom(joueur.getNom());
			joueurDao.setPoint((int) joueur.getPoint());
			joueurDao.setPrenom(joueur.getPrenom());
			joueurDao.setIdTournoi(idTournoi);
		}
		return joueurDao;
	}

}
