package com.tenalic.site.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournoi")
public class TournoiDao {

	@Id
	@Column(name = "id_tournoi")
	private Integer idTournoi;

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

	public Integer getNumeroRoundActuelle() {
		return numeroRoundActuelle;
	}

	public void setNumeroRoundActuelle(Integer numeroRoundActuelle) {
		this.numeroRoundActuelle = numeroRoundActuelle;
	}

}
