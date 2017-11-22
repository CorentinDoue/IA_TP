package com.trip;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class MainTrip {

	public static void main(String[] args) {
		
		
		try {
		    KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-trip");
        	
        	boolean musee = true, accueillant = false, traditionCulinaire = false, traditionFolklorique = false,  monuments = true, vegetationAbondante = false;  
        	int etoile = 3;
        	String ville = "SE", typeVille = "ville ancienne",  region = null, geographie = null, parc = "verdoyant", architecture = "avenues larges";
        	
        	
        	DescriptionActivite da = new DescriptionActivite(ville, etoile, musee, null);
        	DescriptionHabitant dh = new DescriptionHabitant(ville,accueillant , traditionCulinaire, traditionFolklorique);
        	DescriptionVille dv = new DescriptionVille(ville, typeVille, monuments, vegetationAbondante, region, geographie, parc, architecture );
			
			
			
			kSession.insert(da);
			kSession.insert(dh);
			kSession.insert(dv);

			
	      
	
	        
		    kSession.fireAllRules();
			
			System.out.println("ville: " + dv);
			System.out.println("ville: " + dh);
			System.out.println("ville: " + da);
			
			for (Object o : kSession.getObjects()){	        
	            	if (o.getClass().equals(com.trip.Avis.class))
	            		System.out.println(o);
	            }
			
		}  catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	

	}

}
