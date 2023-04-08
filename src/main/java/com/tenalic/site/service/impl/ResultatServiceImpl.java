package com.tenalic.site.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tenalic.site.dao.FakeBaseDeDonnee;
import com.tenalic.site.dto.tournoi.Round;
import com.tenalic.site.service.ResultatService;

@Service
public class ResultatServiceImpl implements ResultatService {

	@Override
	public Set<Integer> getListRound() {
		return getAllNumeroRound();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<Integer> getAllNumeroRound() {
		try {
			return new HashSet(FakeBaseDeDonnee.getInstanceTournoi().getTournoi().getListeRound().stream()
					.map(Round::getNumeroRound).toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Round> getListRoundByNumeroRound(String numeroRound) {
		return getAllRoundByNumeroRound(numeroRound);
	}

	private List<Round> getAllRoundByNumeroRound(String numeroRound) {
		return FakeBaseDeDonnee.getInstanceTournoi().getTournoi().getListeRound().stream()
				.filter(r -> r.getNumeroRound() == Integer.valueOf(numeroRound)).toList();
	}

}
