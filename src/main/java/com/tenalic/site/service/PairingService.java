package com.tenalic.site.service;

import java.util.List;

import com.tenalic.site.dto.tournoi.Round;

public interface PairingService {

	List<Round> creerPairing(String infos);

	void saisirResultatMatch(int table, int round, String cossyWinner, int action);

	boolean toutLesResultatSontRemplis();

	void verifierBye(List<Round> listeRound);

}
