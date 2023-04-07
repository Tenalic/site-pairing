package com.tenalic.site.dto.tournoi;

import java.util.List;

public class Tournoi {

	private int roundActuelle;

	private List<Joueur> listeJoueur;

	private List<Judge> listeJudge;

	private List<Round> listeRound;

	public Tournoi() {
		super();
	}

	public int getRoundActuelle() {
		return roundActuelle;
	}

	public void setRoundActuelle(int roundActuelle) {
		this.roundActuelle = roundActuelle;
	}

	public List<Joueur> getListeJoueur() {
		return listeJoueur;
	}

	public void setListeJoueur(List<Joueur> listeJoeuur) {
		this.listeJoueur = listeJoeuur;
	}

	public List<Judge> getListeJudge() {
		return listeJudge;
	}

	public void setListeJudge(List<Judge> listeJudge) {
		this.listeJudge = listeJudge;
	}

	public List<Round> getListeRound() {
		return listeRound;
	}

	public void setListeRound(List<Round> listeRound) {
		this.listeRound = listeRound;
	}

	@Override
	public String toString() {
		return "Tournoi [roundActuelle=" + roundActuelle + ", listeJoeuur=" + listeJoueur + ", listeJudge=" + listeJudge
				+ ", listeRound=" + listeRound + "]";
	}

}
