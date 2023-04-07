package com.tenalic.site.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tenalic.site.dao.FakeBaseDeDonnee;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Round;
import com.tenalic.site.dto.tournoi.Tournoi;
import com.tenalic.site.service.PairingService;

@Service
public class PairingServiceImpl implements PairingService {

	@Override
	public String creerPairing(String infos) {
		creerNouvelleRound(infos);
		return null;
	}

	private void creerNouvelleRound(String infos) {
		Tournoi tournoi = Optional.ofNullable(FakeBaseDeDonnee.getInstanceTournoi().getTournoi()).orElse(new Tournoi());
		tournoi.setRoundActuelle(tournoi.getRoundActuelle() + 1);
		List<String> listeInfosFormate;
		try {
			listeInfosFormate = Arrays.asList(infos.split(";"));
		} catch (Exception e) {
			throw e;
		}
		tournoi.setListeRound(creerListeRound(listeInfosFormate,
				Optional.ofNullable(tournoi.getListeJoueur()).orElse(new ArrayList<Joueur>()),
				Optional.ofNullable(tournoi.getListeRound()).orElse(new ArrayList<Round>()),
				tournoi.getRoundActuelle()));
	}

	/**
	 * table;cossy
	 * 
	 * @param listeInfosFormate
	 * @param listeJoueur
	 * @param listeRound
	 * @return
	 */
	private List<Round> creerListeRound(List<String> listeInfosFormate, List<Joueur> listeJoueur,
			List<Round> listeRound, int numeroRound) {
		int count = 0;
		Round round = null;
		for (String info : listeInfosFormate) {
			if (count == 0) {
				round = getRoundByTable(Integer.parseInt(info), listeRound, numeroRound);
			}
			switch (count) {
			case 0:
				round.setNumeroTable(Integer.parseInt(info));
				break;
			case 1:
				round = setPlayerRound(findJoueur(listeJoueur, info), round);
				break;
			}
			count++;
			if (count > 1) {
				count = 0;
				round.setNumeroRound(numeroRound);
				listeRound.add(round);
			}
		}
		return listeRound;
	}

	private Round getRoundByTable(int numeroTable, List<Round> listeRound, int numeroRound) {
		for (Round round : listeRound) {
			if (numeroTable == round.getNumeroTable() && numeroRound == round.getNumeroRound()) {
				return round;
			}
		}
		return new Round();
	}

	private Round setPlayerRound(Joueur joueur, Round round) {
		if (round.getJoueur1() == null) {
			round.setJoueur1(joueur);
		} else {
			round.setJoueur2(joueur);
		}
		return round;
	}

	private Joueur findJoueur(List<Joueur> listJoueur, String cossy) {
		return Optional.ofNullable(listJoueur).orElse(new ArrayList<Joueur>()).stream()
				.filter(j -> cossy.equals(j.getCossy())).findFirst().orElseThrow();
	}

}