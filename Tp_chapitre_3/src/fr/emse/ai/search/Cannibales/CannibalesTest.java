package fr.emse.ai.search.Cannibales;


import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;

public class CannibalesTest {

    public static void main(String[] args) {
        CannibalesOrientedGraphProblem p1 = new CannibalesOrientedGraphProblem();


        //Depth first :
        DepthFirstGraphSearch df = new DepthFirstGraphSearch();
        String Sol = df.solve(p1).toString();
        System.out.println("Solution to problem p1 using depth first : " + Sol);

        //Breadth first :
        BreadthFirstGraphSearch bf = new BreadthFirstGraphSearch();
        String Sol2 = bf.solve(p1).toString();
        System.out.println("Solution to problem p1 using breadth-first : " + Sol2);
    }
}