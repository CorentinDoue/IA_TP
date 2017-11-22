package com.trip;

public class Avis {
	public Avis(String ville, String valeur) {
		super();
		this.ville = ville;
		this.valeur = valeur;
	}
	private String ville;
	private String valeur;
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public String toString(){
		return "la ville " + ville + " a un avis: " + valeur;
	}
}
