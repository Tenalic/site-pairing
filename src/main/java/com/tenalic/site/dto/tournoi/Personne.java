package com.tenalic.site.dto.tournoi;

public abstract class Personne {

	private String nom;

	private String prenom;

	private Role role;

	private String cossy;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getCossy() {
		return cossy;
	}

	public void setCossy(String cossy) {
		this.cossy = cossy;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", cossy=" + cossy + "]";
	}

}
