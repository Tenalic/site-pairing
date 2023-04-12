package com.tenalic.site.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tenalic.site.dao.object.RoundAllInfosDao;

public interface RoundAllInfosRepo extends CrudRepository<RoundAllInfosDao, Integer> {

	@Query(value = "SELECT round.*, joueur1.nom as nom_j1,  joueur1.prenom as prenom_j1,"
			+ " joueur1.cossy as cossy_j1, joueur1.point as point_j1,  joueur1.drop as drop_j1,"
			+ " joueur2.nom as nom_j2,  joueur2.prenom as prenom_j2, joueur2.cossy as cossy_j2,"
			+ " joueur2.point as point_j2, joueur2.drop as drop_j2 FROM round "
			+ " left join joueur joueur1 on joueur1.id_joueur = round.id_joueur1"
			+ " left join joueur joueur2 on joueur2.id_joueur = round.id_joueur2 where round.id_tournoi = ?1 "
			+ " and round.numero_round = ?2 order by numero_table asc", nativeQuery = true)
	List<RoundAllInfosDao> findAllRoundAllInfosDaoByIdTournoiAndNumeroRound(int id_tournoi, int numero_round);

}
