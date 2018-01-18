package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.drools.event.rule.DefaultAgendaEventListener;
import org.drools.event.rule.AfterActivationFiredEvent;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	  
   public void run(){
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            //Creates a stateful knowledge session by calling the factory method from the kbase object.
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            //inserted one fact in the session
            ksession.insert(createClassical());
            //Fired all rules for first fact
            ksession.fireAllRules();
            //created another fact
            ksession.insert(createPlaylist());
            //fired the rules for second fact.
            ksession.fireAllRules();
            // Fire all rules fires all the rules loaded in the knowledge as per the pattern matching.
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

   /* This method loads all the Drools resources to the knowledge base (object) and return a knowledge base object. In this case it loads the 
   Rules.drl and checks for the compilation error of that file and loads it.*/
   
    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Rules.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
    //Creating test data for Classical Song so that respective rule is fired.
    private Song createClassical() {
        Song song = new Song("SaReGaMa", Song.Genre.CLASSICAL,2569);
        song.addArtist(new Artist("Pandit", "Jasraj"));
        return song;
    }
    
    //Creating test data for Pop Song so that respective rule is fired.
    private Song createPop() {
        Song song = new Song("Aa jaa meri gaadi main baith jaa", Song.Genre.POP,7654);
        song.addArtist(new Artist("Baba", "Sehgal"));
        return song;
    }
    //Creating test data for Playlist so that respective rule is fired.
    private Playlist createPlaylist() {
        Playlist playlist = new Playlist();
        playlist.setName("My favorite songs");
        
        playlist.addSong(createPop());
        playlist.addSong(createClassical());

        return playlist;
    }

  // Main method to call the run method and to start the execution
    public static final void main(String[] args) {
    	DroolsTest dt = new DroolsTest();
    	dt.run();
    }
    
    }
