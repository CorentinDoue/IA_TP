package fr.emse.ai.search.farmer;


import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class FarmerTest {

    public static void main(String[] args) {
        FarmerOrientedGraphProblem p1 = new FarmerOrientedGraphProblem();


        //Depth first :
        DepthFirstTreeSearch df = new DepthFirstTreeSearch();
        String Sol = df.solve(p1).toString();
        System.out.println("Solution to problem p1 using depth first : "+ Sol);

        //Breadth first :
        BreadthFirstTreeSearch bf = new BreadthFirstTreeSearch();
        String Sol2 = bf.solve(p1).toString();
        System.out.println("Solution to problem p1 using breadth-first : "+ Sol2);
    }
}
