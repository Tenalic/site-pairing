package com.tenalic.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenalic.site.dao.repository.RoundAllInfosRepo;
import com.tenalic.site.dao.repository.RoundRepo;
import com.tenalic.site.dao.repository.TournoiRepo;
import com.tenalic.site.dto.tournoi.Round;
import com.tenalic.site.service.ResultatService;
import com.tenalic.site.utils.mapper.MapperRoundAllInfosDao;

@Service
public class ResultatServiceImpl implements ResultatService {

	@Autowired
	private RoundRepo roundRepo;

	@Autowired
	private RoundAllInfosRepo roundAllInfosRepo;

	@Autowired
	private TournoiRepo tournoiRepo;

	@Override
	public List<Integer> getListRound() {
		return getAllNumeroRound();
	}

	private List<Integer> getAllNumeroRound() {
		try {
			return roundRepo.findAllNumeroRound();
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
		return MapperRoundAllInfosDao.mapRound(roundAllInfosRepo.findAllRoundAllInfosDaoByIdTournoiAndNumeroRound(
				tournoiRepo.findLastTournoi().getIdTournoi(), Integer.parseInt(numeroRound)));
	}

}
