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
import com.tenalic.site.utils.constantes.Constantes;

@Service
public class PairingServiceImpl implements PairingService {

	@Override
	public String creerPairing(String infos) {
		creerNouvelleRound(infos);
		return null;
	}

	@Override
	public List<Round> recupererInfosJoueursRound(String cossy) {
		return recupererInfosRound(cossy);
	}

	private List<Round> recupererInfosRound(String cossy) {
		List<Round> roundPartie1 = FakeBaseDeDonnee.getInstanceTournoi().getTournoi().getListeRound().stream()
				.filter(r -> cossy.equals(r.getJoueur1().getCossy())).toList();
		List<Round> roundPartie2 = FakeBaseDeDonnee.getInstanceTournoi().getTournoi().getListeRound().stream()
				.filter(r -> cossy.equals(r.getJoueur2().getCossy())).toList();
		List<Round> mergedList = new ArrayList<Round>();
		mergedList.addAll(roundPartie1);
		mergedList.addAll(roundPartie2);
		return mergedList;
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
				listeRound = addRoundInList(listeRound, round);
			}
		}
		return verifierListRound(listeRound);
	}

	private List<Round> verifierListRound(List<Round> listeRound) {
		for (int i = 0; i < listeRound.size(); i++) {
			if (listeRound.get(i).getJoueur1() == null) {
				listeRound.get(i).setJoueur1(new Joueur());
			}
			if (listeRound.get(i).getJoueur2() == null) {
				listeRound.get(i).setJoueur2(new Joueur());
			}
		}
		return listeRound;
	}

	private List<Round> addRoundInList(List<Round> listeRound, Round round) {
		int index = 0;
		for (Round r : listeRound) {
			if (r.getNumeroTable() == round.getNumeroTable() && r.getNumeroRound() == round.getNumeroRound()) {
				listeRound.set(index, round);
				return listeRound;
			}
			index++;
		}
		listeRound.add(round);
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
		Joueur joueur = Optional.ofNullable(listJoueur).orElse(new ArrayList<Joueur>()).stream()
				.filter(j -> cossy.equals(j.getCossy())).findFirst().orElse(null);
		if (joueur == null) {
			joueur = new Joueur();
			joueur.setCossy("");
			joueur.setNom("BYE");
			joueur.setPrenom("BYE");
		}
		return joueur;
	}

	@Override
	public void saisirResultatMatch(String cossyWinner, int action) {
		setResultat(cossyWinner, action);
	}

	private void setResultat(String cossyWinner, int action) {
		Tournoi tournoi = FakeBaseDeDonnee.getInstanceTournoi().getTournoi();
		Joueur joueur = tournoi.getListeJoueur().stream().filter(j -> cossyWinner.equals(j.getCossy())).findFirst()
				.orElse(null);
		if (joueur == null) {
			joueur = new Joueur();
			joueur.setNom("");
			joueur.setPrenom("");
			joueur.setCossy("draw");
		}
		setWinner(tournoi.getListeRound(), joueur.getCossy() + " " + joueur.getPrenom() + " " + joueur.getNom(),
				cossyWinner, tournoi.getRoundActuelle(), action);
	}

	private List<Round> setWinner(List<Round> listeRound, String winner, String cossyWinnern, int numeroRound,
			int action) {
		int index = 0;
		for (Round r : listeRound) {
			if ((cossyWinnern.equals(r.getJoueur1().getCossy()) || cossyWinnern.equals(r.getJoueur2().getCossy())
					|| String.valueOf(r.getNumeroTable()).equals(cossyWinnern)) && r.getNumeroRound() == numeroRound
					&& (!r.isDuelFini() || action == Constantes.MODIFIER)) {
				listeRound.get(index).setWinner(winner);
				listeRound.get(index).setDuelFini(true);
				return listeRound;
			}
			index++;
		}
		return null;
	}

}
