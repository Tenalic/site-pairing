package com.tenalic.site.dto.tournoi;

import java.util.Comparator;
import java.util.List;

public class Joueur extends Personne implements Comparable<Joueur> {

	private double point;

	private boolean drop;

	private List<Penalite> listePenatite;

	public Joueur() {
		super();
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public boolean isDrop() {
		return drop;
	}

	public void setDrop(boolean drop) {
		this.drop = drop;
	}

	public List<Penalite> getListePenatite() {
		return listePenatite;
	}

	public void setListePenatite(List<Penalite> listePenatite) {
		this.listePenatite = listePenatite;
	}

	@Override
	public String toString() {
		return "Joueur [point=" + point + ", drop=" + drop + ", listePenatite=" + listePenatite + "]";
	}

	@Override
	public int compareTo(Joueur o) {
		return Comparator.comparing(Joueur::getNom).thenComparing(Personne::getPrenom).thenComparing(Personne::getCossy)
				.compare(this, o);
	}

}
