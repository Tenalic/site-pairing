package com.tenalic.site.service;

import java.util.List;

import com.tenalic.site.dto.tournoi.Round;

public interface ResultatService {

	List<Integer> getListRound();

	List<Round> getListRoundByNumeroRound(String numeroRound);
}
