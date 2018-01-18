package com.cube;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

	public static void main(String[] args) {
		try {
			
			
		    KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rulesCube");

			
			Cube c1 = new Cube (1,"c1");
			Cube c2 = new Cube (2, "c2");
			Cube c3 = new Cube (3, "c3");
			Cube c4 = new Cube (4, "c4");
			Cube c5 = new Cube (5, "c5");
		
			
			kSession.insert(c1);
			kSession.insert(c2);
			kSession.insert(c3);
			kSession.insert(c4);
			kSession.insert(c5);

			
	         for (Object fc : kSession.getObjects()){	        
	            	if (fc.getClass().equals(com.cube.Cube.class))
						((Cube)fc).affiche();
	            }
	
	         
	         kSession.fireAllRules();


			for (Object fc : kSession.getObjects()){
				if (fc.getClass().equals(com.cube.Cube.class))
					((Cube)fc).affiche();
			}
			
		}  catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	}

}
