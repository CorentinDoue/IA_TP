package com.sample;

/**
 *Helper class to see which rule got triggered in the sample application
 * @author vivek
 */

import org.drools.spi.KnowledgeHelper;

public class Helper {
	
	public static void help(final KnowledgeHelper drools, final String message){
        System.out.print(message);
        System.out.print("\nrule triggered: " + drools.getRule().getName());
    }
    
    public static void helper(final KnowledgeHelper drools){
        System.out.print("\nrule triggered: " + drools.getRule().getName());
    }


}
