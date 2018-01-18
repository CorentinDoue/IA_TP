//----------------------------------------------------------------------------
// Copyright (C) 2004  Yasser EL-Manzalawy.
// 
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
// Contact the Author:
// Yasser EL-Manzalawy
// e-mail: ymelmanz@yahoo.com
//----------------------------------------------------------------------------

/*
 * Project: GraphPlan 1.0
 * Class:   graphplan.GraphPlan
 *
 * Date:    2004-03-31
 *
 * Author:  Yasser EL-Manzalawy
 * Email:   ymelmanz@yahoo.com
 */

package graphplan;

import java.util.*;
import java.io.*;
import parser.*;

/**
 * Class GraphPlan.
 *  
 * @author  Yasser EL-Manzalawy
 */
public class GraphPlan {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The operators.
     */
    private TOperatorSet operators;

    /**
     * The objects.
     */
    private ObjectSet objects;

    /**
     * The initials.
     */
    private Conjunction initials;

    /**
     * The goal.
     */
    private Conjunction goal;

    /**
     * The first prop.
     */
    private PropositionLayer firstProp=null;

    /**
     * The last prop.
     */
    private PropositionLayer lastProp=null;

    /**
     * The valid plan.
     */
    private boolean validPlan=false;

    /**
     * The levels.
     */
    private int levels=0;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GraphPlan.
     */
    public GraphPlan() {
        operators = new TOperatorSet();
        objects = new ObjectSet();
        initials = new Conjunction();
        goal = new Conjunction();
    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * ...
     *  
     * @param args The args array.
     */
    public void init(String[] args) {
        System.out.println("JPlan Version 1.0 By Yasser EL-Manzalawy ymelmanz@yahoo.com");

        if (args.length == 0)
        {
            System.out.println("Usage: GraphPlan operators_file facts_file [max_level]");
        }
        else if (args.length >= 2)
        {
            // parse operators file
            GParser parser = null;
            try {
                parser = new GParser(new java.io.FileInputStream(args[0]));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("JPlan Version 1.0:  File " + args[0] + " not found.");
                System.exit(0);
            }
            try {
                operators = parser.OpFile();
            } catch (ParseException ex) {
                System.out.println ("Error Parsing Operators");
                ex.printStackTrace();
                System.exit(0);
            }
            System.out.println("Total operators parsed:" + operators.size());
            // parse facts file
            try {
                parser.ReInit (new java.io.FileInputStream(args[1]));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("JPlan Version 1.0:  File " + args[1] + " not found.");
                System.exit(0);
            }
            try {
                objects = parser.Objects();
                initials = parser.InitState();
                goal = parser.Goal();
            } catch (ParseException ex) {
                System.out.println ("Error Parsing Facts File");
                ex.printStackTrace();
                System.exit(0);
            }
            System.out.println("Total objects parsed:" + objects.size());
            System.out.println("Total initials parsed:" + initials.size());
            System.out.println("Total goals parsed:" + goal.size());
            if (args.length == 3)
            {
                try {
                    G.MaxLevel = Integer.parseInt (args[2], 10);
                } catch (NumberFormatException e) {
                }
            }
            System.out.print ("Setting Max Graph Levels to: " + G.MaxLevel);
            // init each TOperator with valid unifiers
            operators.initUnifiers (objects);
            boolean done = CreateGraph();
            if (done)
            System.out.println ("\nGraph Created Successfully");
            else
            System.out.println ("\nGraph Creation Failed");
            // this code is for debugging only
            // writes the planning graph to a text file
            try{
                FileWriter fw = new FileWriter ("output.gp");
                fw.write (this.toString(), 0, this.toString().length());
                fw.close();
            } catch (IOException e) {
            }
            // search for a valid plan
            if (done)
            {
                if (lastProp.getPrevLayer().searchPlan(goal))	// plan is found for goal
                {
                    validPlan = true;
                }
                else
                System.out.println ("Error in searching for the plan");
            }
            // writing the plan
            Vector plan = getPlan();
            try{
                FileWriter fw = new FileWriter ("output.pln");
                Enumeration e = plan.elements();
                while (e.hasMoreElements())
                {
                    String pstep = (String) e.nextElement() + "\n";
                    fw.write (pstep, 0, pstep.length());
                }
                fw.close();
                System.out.println ("\nPlan Generated Successfully");
            } catch (IOException e) {
            }
        }
    }

    /**
     * ...
     *  
     * @return  The boolean.
     */
    public boolean CreateGraph() {
        firstProp = new PropositionLayer();
        firstProp.setInitLayer (initials);
        lastProp = firstProp;
        levels = 0;
        for (int i = 0; i < G.MaxLevel; i++)
        {
            levels++;
            // create Ai and Pi+1
            Vector apps = operators.generateActions (lastProp.getConjunction());
            if (apps.size() == 0)
            {
                // TODO: throw an exception
                System.out.println ("No applicable actions at level: " + levels);
                return false;
            }
            ActionLayer aLayer = new ActionLayer (lastProp, apps );
            lastProp.setNextLayer (aLayer);
            // point to Pi+1
            lastProp = aLayer.getNextLayer();
            // test that all goals are reachable
            if (ReachableGoals())
            return true;
            // ToDo: test that graph levels off (Done)
            if (levelOff())
            {
                System.out.println ("Graph Levels Off at level" + levels);
                return false;
            }
        } // end for
        System.out.println ("Graph Creation Error: Max Level reached" + G.MaxLevel);
        return false;
    }

    /**
     * ...
     *  
     * @return  The string.
     */
    public String toString() {
        PropositionLayer pPointer = firstProp;
        ActionLayer aPointer = null;
        String s = new String();
        while (pPointer != null)
        {
            s += pPointer.toString();
            aPointer = pPointer.getNextLayer();
            if (aPointer != null)
            {
                s += aPointer.toString();
                pPointer = aPointer.getNextLayer();
            }
            else
            pPointer = null;
        }
        return s;
    }

    /**
     * returns a Vector of Strings represents the generated plan steps
     * TODO: we lose the level information (steps in the same level that
     * could be executed in parallel)
     *  
     * @return  The plan.
     */
    public Vector getPlan() {
        Vector plan = new Vector();
        if (validPlan)
        {
            ActionLayer act = firstProp.getNextLayer();
            while (act != null)
            {
                plan.addAll (act.getApplicableActions());
                act = act.getNextLayer().getNextLayer();
            }
        }
        return plan;
    }

    /**
     * ...
     *  
     * @return  The boolean.
     */
    private boolean ReachableGoals() {
        int len = goal.size();
        // all goals are reachbale
        for (int i = 0; i < len; i++)
        {
            if (lastProp.getConjunction().contains (goal.getLiteral(i))== false)
            return false;
        }
        // no mutex relation
        for (int i = 0; i < len; i++)
        {
            Proposition p1 = lastProp.getProposition (goal.getLiteral(i));
            for (int j = i + 1; j < len; j++)
            {
                Proposition p2 = lastProp.getProposition (goal.getLiteral(j));
                if (p1.isMutex(p2))
                return false;
            }
        }
        return true;
    }

    /**
     * returns true when the last 2 proposition/action layers are identical
     *  
     * @return  The boolean.
     */
    private boolean levelOff() {
        if (levels < 2)
        return false;
        PropositionLayer p = lastProp;
        ActionLayer act = lastProp.getPrevLayer();
        if ( p.equal (act.getPrevLayer()) == false)
        return false;
        else
        {
            p = act.getPrevLayer();
            if (act.equal (p.getPrevLayer()) == false)
            return false;
        }
        return true;
    }

    /**
     * ...
     */
    private void printPlan() {
        ActionLayer act = firstProp.getNextLayer();
        System.out.println ("Printing the Plan");
        while (act != null)
        {
            act.printApplicable();
            act = act.getNextLayer().getNextLayer();
        }
    }


    // ------------------------------------------------------------------------
    // --- static method                                                    ---
    // ------------------------------------------------------------------------
    /**
     * ...
     *  
     * @param args The args array.
     */
    public static void main(String[] args) {
        // read input files and construct member objects
        GraphPlan graph = new GraphPlan();
        graph.init(args);
    }

} // end GraphPlan
