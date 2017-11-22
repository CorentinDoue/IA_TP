package com.trip;

import org.kie.api.definition.type.ClassReactive;

@ClassReactive
public class DescriptionHabitant extends Description{

	
	private boolean accueillant;
	private boolean traditionCulinaire;
	private boolean traditionFolklorique;
	
	
	public DescriptionHabitant(String nom, boolean accueillant, boolean traditionCulinaire, boolean traditionFolklorique) {
		super(nom);
		this.accueillant = accueillant;
		this.traditionCulinaire = traditionCulinaire;
		this.traditionFolklorique = traditionFolklorique;
	}
	
	public boolean isAccueillant() {
		return accueillant;
	}
	public void setAccueillant(boolean autochtonesAccueillants) {
		this.accueillant = autochtonesAccueillants;
	}
	public boolean isTraditionCulinaire() {
		return traditionCulinaire;
	}
	public void setTraditionCulinaire(boolean traditionCulinaire) {
		this.traditionCulinaire = traditionCulinaire;
	}
	public boolean isTraditionFolklorique() {
		return traditionFolklorique;
	}
	public void setTraditionFolklorique(boolean traditionFolklorique) {
		this.traditionFolklorique = traditionFolklorique;
	}
	public boolean isTraditionsFolkloriques() {
		return traditionFolklorique;
	}
	public void setTraditionsFolkloriques(boolean traditionFolklorique) {
		this.traditionFolklorique = traditionFolklorique;
	}

	@Override
	public String toString() {
		return "DescriptionHabitant [accueillant=" + accueillant + ", traditionCulinaire=" + traditionCulinaire
				+ ", traditionFolklorique=" + traditionFolklorique + ", nomVille=" + nomVille + "]";
	}
	

}
