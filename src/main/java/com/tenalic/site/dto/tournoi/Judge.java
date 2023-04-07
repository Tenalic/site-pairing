package com.tenalic.site.dto.tournoi;

import java.util.List;

public class Judge extends Personne {

	private Role role;
	
	private List<Penalite> listePenaliteMise;

	public Judge() {
		super();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Penalite> getListePenaliteMise() {
		return listePenaliteMise;
	}

	public void setListePenaliteMise(List<Penalite> listePenaliteMise) {
		this.listePenaliteMise = listePenaliteMise;
	}

	@Override
	public String toString() {
		return "Judge [role=" + role + ", listePenaliteMise=" + listePenaliteMise + "]";
	}
		
	
}
