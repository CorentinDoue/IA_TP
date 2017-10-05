package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstGraphSearch;

public class SimpleTest {

    public static void main(String[] args) {
        SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        SimpleNoOrientedGraphProblem p2 = new SimpleNoOrientedGraphProblem();


        //Depth first :
        //DepthFirstTreeSearch df = new DepthFirstTreeSearch();
        //String Sol = df.solve(p1).toString();
       // System.out.println("Solution to problem p1 using depth first : "+ Sol);

        //Breadth first :
        //BreadthFirstTreeSearch bf = new BreadthFirstTreeSearch();
        //String Sol2 = bf.solve(p1).toString();
        //System.out.println("Solution to problem p1 using breadth-first : "+ Sol2);

        //Depth first avec graph non orienté :

        //Sol = df.solve(p2).toString();
        //System.out.println("Solution to problem p2 using depth first : "+ Sol);

        //Le programme boucle indéfiniment

        //Breadth first avec graph non orienté:

        String Sol2 = bf.solve(p2).toString();
        System.out.println("Solution to problem p2 using breadth-first : "+ Sol2);

        //Celui-ci ne boucle pas

        //Depth first :
        DepthFirstGraphSearch dfg = new DepthFirstGraphSearch();
        String Sol = dfg.solve(p2).toString();
        System.out.println("Solution to problem p2 using depth first in graph search : "+ Sol);

        //Breadth first :
        BreadthFirstGraphSearch bfg = new BreadthFirstGraphSearch();
        Sol2 = bfg.solve(p2).toString();
        System.out.println("Solution to problem p2 using breadth-first in graph search : "+ Sol2);


    }
}
