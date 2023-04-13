package com.tenalic.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenalic.site.dao.repository.RoundAllInfosRepo;
import com.tenalic.site.dto.tournoi.Round;
import com.tenalic.site.service.RoundService;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.mapper.MapperRoundAllInfosDao;

@Service
public class RoundServiceImpl implements RoundService {

	@Autowired
	private RoundAllInfosRepo allInfosRepo;

	@Autowired
	private TournoiServiceInterface tournoiService;

	@Override
	public List<Round> recuperListRoundLastTournoi() {
		return MapperRoundAllInfosDao
				.mapRound(allInfosRepo.findAllRoundAllInfosDaoByIdTournoi(tournoiService.getTournoi().getIdTournoi()));
	}

	@Override
	public List<Round> recupererInfosJoueursRound(String cossy) {
		return MapperRoundAllInfosDao.mapRound(allInfosRepo
				.findAllRoundAllInfosDaoByIdTournoiAndCossy(tournoiService.getTournoi().getIdTournoi(), cossy));
	}

}
