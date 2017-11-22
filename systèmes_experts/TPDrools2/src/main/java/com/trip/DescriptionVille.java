package com.trip;


import org.kie.api.definition.type.ClassReactive;

@ClassReactive
public class DescriptionVille extends Description{
	
	
	
	// belle, historique, méritant détour, ancienne,
	private String typeVille;  
	private boolean monuments;
	private boolean vegetationAbondante;
	// provence
	private String region;
	// bord de mer
	private String geographie;
	// verdoyant
	private String parc;
	// largeAvenue
	private String architecture;
	
	
	public DescriptionVille(String nom, String typeVille, boolean monuments, boolean vegetationAbondante, String region,
			String geographie, String parc, String architecture) {
		super(nom);
		this.typeVille = typeVille;
		this.monuments = monuments;
		this.vegetationAbondante = vegetationAbondante;
		this.region = region;
		this.geographie = geographie;
		this.parc = parc;
		this.architecture = architecture;
	}

	
	public String getTypeVille() {
		return typeVille;
	}
	public void setTypeVille(String typeVille) {
		this.typeVille = typeVille;
	}
	public boolean isMonuments() {
		return monuments;
	}
	public void setMonuments(boolean monuments) {
		this.monuments = monuments;
	}
	public boolean isVegetationAbondante() {
		return vegetationAbondante;
	}
	public void setVegetationAbondante(boolean vegetationAbondante) {
		this.vegetationAbondante = vegetationAbondante;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGeographie() {
		return geographie;
	}
	public void setGeographie(String geographie) {
		this.geographie = geographie;
	}
	public String getParc() {
		return parc;
	}
	public void setParc(String parc) {
		this.parc = parc;
	}
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}


	@Override
	public String toString() {
		return "DescriptionVille [typeVille=" + typeVille + ", monuments=" + monuments + ", vegetationAbondante="
				+ vegetationAbondante + ", region=" + region + ", geographie=" + geographie + ", parc=" + parc
				+ ", architecture=" + architecture + ", nomVille=" + nomVille + "]";
	}

	
	
}
