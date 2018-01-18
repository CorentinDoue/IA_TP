import aima.core.agent.Action;
import aima.core.learning.reinforcement.PerceptStateReward;
import aima.core.probability.mdp.ActionsFunction;
import aima.core.util.FrequencyCounter;
import aima.core.util.datastructure.Pair;

public class HumanVsHumanGame {
    public static void main(String[] args) {
        Grid g = new Grid();
        Agent agent1 = new HumanAgent(g, "1", "X");
        Agent agent2 = new HumanAgent(g, "2", "O");

        int tour=0;
        while(!g.isWon())
        {
            System.out.println(g);
            if(tour==0)
                agent1.play();
            else agent2.play();
            tour = 1-tour;
        }
        System.out.println(g);
        System.out.println("Bravo ! Game over !!");

        TicTacToeAction ticTacToeAction = new TicTacToeAction(1);


    }
}
