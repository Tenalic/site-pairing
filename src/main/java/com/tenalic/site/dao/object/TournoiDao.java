package com.tenalic.site.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournoi")
public class TournoiDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tournoi")
	private Integer idTournoi;

	@Column(name = "id_joueur")
	private Integer idJoueur;

	@Column(name = "id_judge")
	private Integer idJudge;

	@Column(name = "id_round")
	private Integer idRound;

	@Column(name = "numero_round_actuelle")
	private Integer numeroRoundActuelle;

	public TournoiDao() {
		super();
	}

	public Integer getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(Integer idTournoi) {
		this.idTournoi = idTournoi;
	}

	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer idJoueur) {
		this.idJoueur = idJoueur;
	}

	public Integer getIdJudge() {
		return idJudge;
	}

	public void setIdJudge(Integer idJudge) {
		this.idJudge = idJudge;
	}

	public Integer getIdRound() {
		return idRound;
	}

	public void setIdRound(Integer idRound) {
		this.idRound = idRound;
	}

	public Integer getNumeroRoundActuelle() {
		return numeroRoundActuelle;
	}

	public void setNumeroRoundActuelle(Integer numeroRoundActuelle) {
		this.numeroRoundActuelle = numeroRoundActuelle;
	}

}
