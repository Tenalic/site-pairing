package com.tenalic.site.service;


public interface PairingService {

	String creerPairing(String infos);

	void saisirResultatMatch(int table, int round, String cossyWinner, int action);

	boolean toutLesResultatSontRemplis();

}
