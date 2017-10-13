package fr.emse.ai.search.can;



import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstGraphSearch;

public class CanTest {

    public static void main(String[] args) {
        CanGraphProblem p1 = new CanGraphProblem();


        //Depth first :
        DepthFirstGraphSearch df = new DepthFirstGraphSearch();
        String Sol = df.solve(p1).toString();
        System.out.println("Solution to problem p1 using depth first : "+ Sol);

        //Breadth first :
        BreadthFirstGraphSearch bf = new BreadthFirstGraphSearch();
        String Sol2 = bf.solve(p1).toString();
        System.out.println("Solution to problem p1 using breadth-first : "+ Sol2);
    }
}
