package com.tenalic.site.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tenalic.site.dao.object.TournoiDao;

public interface TournoiRepo extends CrudRepository<TournoiDao, Integer> {

	@Query(value = "SELECT * FROM TOURNOI ORDER BY ID_TOURNOI DESC LIMIT 1", nativeQuery = true)
	TournoiDao findLastTournoi();

}
