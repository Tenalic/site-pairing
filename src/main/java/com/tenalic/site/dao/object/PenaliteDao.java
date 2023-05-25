package com.tenalic.site.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "penalite")
public class PenaliteDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_penalite")
	private Integer idPenalite;

	@Column(name = "id_joueur")
	private Integer idJoueur;

	@Column(name = "id_judge")
	private Integer idJudge;

	@Column(name = "type_penalite")
	private String typePenalite;

	@Column(name = "sanction")
	private String sanction;

	@Column(name = "description")
	private String description;

	@Column(name = "temps_supplementaire")
	private Float tempsSupplementaire;

	public PenaliteDao() {
		super();
	}

	public Integer getIdPenalite() {
		return idPenalite;
	}

	public void setIdPenalite(Integer idPenalite) {
		this.idPenalite = idPenalite;
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

	public String getTypePenalite() {
		return typePenalite;
	}

	public void setTypePenalite(String typePenalite) {
		this.typePenalite = typePenalite;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getTempsSupplementaire() {
		return tempsSupplementaire;
	}

	public void setTempsSupplementaire(Float tempsSupplementaire) {
		this.tempsSupplementaire = tempsSupplementaire;
	}

}
