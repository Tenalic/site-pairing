package com.tenalic.site.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "round")
public class RoundDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_round")
	private Integer idRound;
	
	@Column(name = "id_tournoi")
	private Integer idTournoi;

	@Column(name = "id_joueur1")
	private Integer idJoueur1;

	@Column(name = "id_joueur2")
	private Integer idJoueur2;

	@Column(name = "numero_round")
	private Integer numeroRound;
	
	@Column(name = "numero_table")
	private Integer numeroTable;

	@Column(name = "temps_supplementaire")
	private Long tempsSupplementaire;

	@Column(name = "winner_name")
	private String winnerName;

	@Column(name = "winner_cossy")
	private String winnerCossy;

	@Column(name = "id_joueur_winner")
	private Integer winnerJoueurId;

	@Column(name = "duel_fini")
	private Boolean duelFini;

	public RoundDao() {
		super();
	}

	public Integer getIdRound() {
		return idRound;
	}

	public void setIdRound(Integer idRound) {
		this.idRound = idRound;
	}

	public Integer getIdJoueur1() {
		return idJoueur1;
	}

	public void setIdJoueur1(Integer idJoueur1) {
		this.idJoueur1 = idJoueur1;
	}

	public Integer getIdJoueur2() {
		return idJoueur2;
	}

	public void setIdJoueur2(Integer idJoueur2) {
		this.idJoueur2 = idJoueur2;
	}

	public Integer getNumeroRound() {
		return numeroRound;
	}

	public void setNumeroRound(Integer numeroRound) {
		this.numeroRound = numeroRound;
	}

	public Long getTempsSupplementaire() {
		return tempsSupplementaire;
	}

	public void setTempsSupplementaire(Long tempsSupplementaire) {
		this.tempsSupplementaire = tempsSupplementaire;
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

	public String getWinnerCossy() {
		return winnerCossy;
	}

	public void setWinnerCossy(String winnerCossy) {
		this.winnerCossy = winnerCossy;
	}

	public Integer getWinnerJoueurId() {
		return winnerJoueurId;
	}

	public void setWinnerJoueurId(Integer winnerJoueurId) {
		this.winnerJoueurId = winnerJoueurId;
	}

	public Boolean getDuelFini() {
		return duelFini;
	}

	public void setDuelFini(Boolean duelFini) {
		this.duelFini = duelFini;
	}

	public Integer getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(Integer idTournoi) {
		this.idTournoi = idTournoi;
	}

	public Integer getNumeroTable() {
		return numeroTable;
	}

	public void setNumeroTable(Integer numeroTable) {
		this.numeroTable = numeroTable;
	}
	
	

}
