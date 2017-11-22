package com.trip;
import org.kie.api.definition.type.ClassReactive;

@ClassReactive
public class DescriptionActivite extends Description {

	public DescriptionActivite(String nom, int nombreEtoiles, boolean musees, String restaurant) {
		super(nom);
		this.nombreEtoiles = nombreEtoiles;
		this.musees = musees;
		this.restaurant = restaurant;
	}
	private int nombreEtoiles;
	
	private boolean musees;
	// 3Etoiles, bon, trèsBon, 3 toques;
	private String restaurant;
	
	public boolean isMusees() {
		return musees;
	}
	public void setMusees(boolean musees) {
		this.musees = musees;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public int getNombreEtoiles() {
		return nombreEtoiles;
	}
	public void setNombreEtoiles(int nombreEtoiles) {
		this.nombreEtoiles = nombreEtoiles;
	}
	@Override
	public String toString() {
		return "DescriptionActivite [nombreEtoiles=" + nombreEtoiles + ", musees=" + musees + ", restaurant="
				+ restaurant + ", nomVille=" + nomVille + "]";
	}

}
