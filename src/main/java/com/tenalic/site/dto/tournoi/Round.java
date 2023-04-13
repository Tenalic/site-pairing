package com.tenalic.site.dto.tournoi;

public class Round {

	private int numeroRound;

	private int idRound;

	private Joueur joueur1;

	private Joueur joueur2;

	private String winner;

	private boolean duelFini;

	private int numeroTable;

	private long tempsSupplementaire;

	public Round() {
		super();
	}

	public int getNumeroRound() {
		return numeroRound;
	}

	public void setNumeroRound(int numeroRound) {
		this.numeroRound = numeroRound;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public int getNumeroTable() {
		return numeroTable;
	}

	public void setNumeroTable(int numeroTable) {
		this.numeroTable = numeroTable;
	}

	public long getTempsSupplementaire() {
		return tempsSupplementaire;
	}

	public void setTempsSupplementaire(long tempsSupplementaire) {
		this.tempsSupplementaire = tempsSupplementaire;
	}

	@Override
	public String toString() {
		return "Round [numeroRound=" + numeroRound + ", joueur1=" + joueur1 + ", joueur2=" + joueur2 + ", numeroTable="
				+ numeroTable + ", tempsSupplementaire=" + tempsSupplementaire + "]";
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public boolean isDuelFini() {
		return duelFini;
	}

	public void setDuelFini(boolean duelFini) {
		this.duelFini = duelFini;
	}

	public int getIdRound() {
		return idRound;
	}

	public void setIdRound(int idRound) {
		this.idRound = idRound;
	}

}
