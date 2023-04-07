package com.tenalic.site.dao;

import com.tenalic.site.dto.tournoi.Tournoi;

public class FakeBaseDeDonnee {

	private static FakeBaseDeDonnee instance = null;

	private Tournoi tournoi;

	private FakeBaseDeDonnee() {
	}

	public static FakeBaseDeDonnee getInstanceTournoi() {
		if (instance == null) {
			instance = new FakeBaseDeDonnee();
		}
		return instance;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

}
