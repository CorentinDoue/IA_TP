package com.trip;

import org.kie.api.definition.type.ClassReactive;

@ClassReactive
public class Description {
	protected String nomVille;

	public Description(String nom) {
		nomVille = nom;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nameVille) {
		this.nomVille = nameVille;
	}
}
