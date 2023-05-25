package com.tenalic.site.service;

import java.util.List;

import com.tenalic.site.dto.tournoi.Round;

public interface RoundService {

	List<Round> recuperListRoundLastTournoi();
	
	List<Round> recupererInfosJoueursRound(String cossy);

}
