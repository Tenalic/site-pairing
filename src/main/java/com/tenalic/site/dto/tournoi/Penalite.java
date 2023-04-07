package com.tenalic.site.dto.tournoi;

public class Penalite {

	private Judge judge;

	private int round;

	private Joueur joueur;

	private String typePenaite;

	private String sanction;

	private String desription;

	private long tempsSupplementaire;

	public Penalite() {
		super();
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public String getTypePenaite() {
		return typePenaite;
	}

	public void setTypePenaite(String typePenaite) {
		this.typePenaite = typePenaite;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public long getTempsSupplementaire() {
		return tempsSupplementaire;
	}

	public void setTempsSupplementaire(long tempsSupplementaire) {
		this.tempsSupplementaire = tempsSupplementaire;
	}

	@Override
	public String toString() {
		return "Penalite [judge=" + judge + ", round=" + round + ", joueur=" + joueur + ", typePenaite=" + typePenaite
				+ ", sanction=" + sanction + ", desription=" + desription + ", tempsSupplementaire="
				+ tempsSupplementaire + "]";
	}

}
