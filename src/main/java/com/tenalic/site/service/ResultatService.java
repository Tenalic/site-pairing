package com.tenalic.site.service;

import java.util.List;
import java.util.Set;

import com.tenalic.site.dto.tournoi.Round;

public interface ResultatService {

	Set<Integer> getListRound();

	List<Round> getListRoundByNumeroRound(String numeroRound);
}
