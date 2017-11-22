package com.cube;



public class Cube {
	private String identifiant; 
	private String poseSur;
	private int valeur;
	
	
	public Cube(int valeur, String identifiant, String poseSur) {
		super();
		this.identifiant = identifiant;
		this.poseSur = poseSur;
		this.valeur = valeur;
	}
	
	public Cube(int valeur, String identifiant) {
		this(valeur, identifiant, "sol");
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPoseSur() {
		return poseSur;
	}

	public void setPoseSur(String poseSur) {
		this.poseSur = poseSur;
	}
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void affiche(){
		System.out.println(" le Cube " + getIdentifiant() + " est posé sur " + getPoseSur());
	}
	
	
	

}
