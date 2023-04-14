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

	@Query(value = "SELECT round.*, joueur1.nom AS nom_j1, joueur1.prenom AS prenom_j1, joueur1.cossy AS cossy_j1, joueur1.point AS point_j1, joueur1.drop AS drop_j1, joueur2.nom AS nom_j2, joueur2.prenom AS prenom_j2, joueur2.cossy AS cossy_j2, joueur2.point AS point_j2, joueur2.drop AS drop_j2 FROM round LEFT JOIN joueur joueur1 ON joueur1.id_joueur = round.id_joueur1 LEFT JOIN joueur joueur2 ON joueur2.id_joueur = round.id_joueur2 WHERE round.id_tournoi = ?1 AND (joueur1.cossy = '?2' OR joueur2.cossy = '?2') ORDER BY numero_round DESC", nativeQuery = true)
	List<RoundAllInfosDao> findAllRoundAllInfosDaoByIdTournoiAndCossy(int id_tournoi, String cossy);

	@Query(value = "SELECT round.*, joueur1.nom AS nom_j1, joueur1.prenom AS prenom_j1, joueur1.cossy AS cossy_j1, joueur1.point AS point_j1, joueur1.drop AS drop_j1, joueur2.nom AS nom_j2, joueur2.prenom AS prenom_j2, joueur2.cossy AS cossy_j2, joueur2.point AS point_j2, joueur2.drop AS drop_j2 FROM round LEFT JOIN joueur joueur1 ON joueur1.id_joueur = round.id_joueur1 LEFT JOIN joueur joueur2 ON joueur2.id_joueur = round.id_joueur2 WHERE round.id_tournoi = ?1 AND (round.id_joueur1 = ?2 OR round.id_joueur2 = ?2) ORDER BY numero_round DESC", nativeQuery = true)
	List<RoundAllInfosDao> findAllRoundAllInfosDaoByIdTournoiAndIdJoueur(int id_tournoi, int id_joueur);

	@Query(value = "SELECT round.*, joueur1.nom AS nom_j1, joueur1.prenom AS prenom_j1, joueur1.cossy AS cossy_j1, joueur1.point AS point_j1, joueur1.drop AS drop_j1, joueur2.nom AS nom_j2, joueur2.prenom AS prenom_j2, joueur2.cossy AS cossy_j2, joueur2.point AS point_j2, joueur2.drop AS drop_j2 FROM round LEFT JOIN joueur joueur1 ON joueur1.id_joueur = round.id_joueur1 LEFT JOIN joueur joueur2 ON joueur2.id_joueur = round.id_joueur2 WHERE round.id_tournoi = ?1 ORDER BY numero_round DESC", nativeQuery = true)
	List<RoundAllInfosDao> findAllRoundAllInfosDaoByIdTournoi(int id_tournoi);

}
