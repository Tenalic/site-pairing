package com.tenalic.site.service;

import java.util.List;

import com.tenalic.site.dto.tournoi.Round;

public interface PairingService {

	String creerPairing(String infos);

	List<Round> recupererInfosJoueursRound(String cossy);

	void saisirResultatMatch(String cossyWinner);

}
