package com.tenalic.site.dao.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoundAllInfosDao {

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

	@Column(name = "nom_j1")
	private String nom_j1;

	@Column(name = "prenom_j1")
	private String prenom_j1;

	@Column(name = "cossy_j1")
	private String cossy_j1;

	@Column(name = "point_j1")
	private Integer point_j1;

	@Column(name = "drop_j1")
	private Boolean drop_j1;

	@Column(name = "nom_j2")
	private String nom_j2;

	@Column(name = "prenom_j2")
	private String prenom_j2;

	@Column(name = "cossy_j2")
	private String cossy_j2;

	@Column(name = "point_j2")
	private Integer point_j2;

	@Column(name = "drop_j2")
	private Boolean drop_j2;

	public RoundAllInfosDao() {
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

	public String getNom_j1() {
		return nom_j1;
	}

	public void setNom_j1(String nom_j1) {
		this.nom_j1 = nom_j1;
	}

	public String getPrenom_j1() {
		return prenom_j1;
	}

	public void setPrenom_j1(String prenom_j1) {
		this.prenom_j1 = prenom_j1;
	}

	public String getCossy_j1() {
		return cossy_j1;
	}

	public void setCossy_j1(String cossy_j1) {
		this.cossy_j1 = cossy_j1;
	}

	public Integer getPoint_j1() {
		return point_j1;
	}

	public void setPoint_j1(Integer point_j1) {
		this.point_j1 = point_j1;
	}

	public Boolean isDrop_j1() {
		return drop_j1;
	}

	public void setDrop_j1(Boolean drop_j1) {
		this.drop_j1 = drop_j1;
	}

	public String getNom_j2() {
		return nom_j2;
	}

	public void setNom_j2(String nom_j2) {
		this.nom_j2 = nom_j2;
	}

	public String getPrenom_j2() {
		return prenom_j2;
	}

	public void setPrenom_j2(String prenom_j2) {
		this.prenom_j2 = prenom_j2;
	}

	public String getCossy_j2() {
		return cossy_j2;
	}

	public void setCossy_j2(String cossy_j2) {
		this.cossy_j2 = cossy_j2;
	}

	public Integer getPoint_j2() {
		return point_j2;
	}

	public void setPoint_j2(Integer point_j2) {
		this.point_j2 = point_j2;
	}

	public Boolean isDrop_j2() {
		return drop_j2;
	}

	public void setDrop_j2(Boolean drop_j2) {
		this.drop_j2 = drop_j2;
	}
}
