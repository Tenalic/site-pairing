package com.tenalic.site.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "judge")
public class JudgeDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_judge")
	private Integer idJudge;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "cossy")
	private String cossy;

	public JudgeDao() {
		super();
	}

	public Integer getIdJudge() {
		return idJudge;
	}

	public void setIdJudge(Integer idJudge) {
		this.idJudge = idJudge;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCossy() {
		return cossy;
	}

	public void setCossy(String cossy) {
		this.cossy = cossy;
	}

}
