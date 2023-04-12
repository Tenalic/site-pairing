package com.tenalic.site.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tenalic.site.dao.object.RoundDao;

public interface RoundRepo extends CrudRepository<RoundDao, Integer> {

	List<RoundDao> findByIdTournoi(int idTournoi);

	List<RoundDao> findByIdTournoiAndNumeroRound(int idTournoi, int numeroRound);

	@Query(value = "SELECT * FROM ROUND WHERE id_tournoi = ?1 and numero_round = ?2 and winner_name is null", nativeQuery = true)
	List<RoundDao> findAllRoundSansResultat(int id_tournoi, int numero_round);

	@Query(value = "SELECT DISTINCT numero_round FROM ROUND ORDER BY numero_round desc", nativeQuery = true)
	List<Integer> findAllNumeroRound();

}
