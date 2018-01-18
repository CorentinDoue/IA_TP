import aima.core.learning.reinforcement.PerceptStateReward;
import aima.core.probability.mdp.ActionsFunction;

public class TicTacToeQLearningAgent extends QLearningAgent<Grid,TicTacToeAction> {

    Grid grid;
    String name;
    String symbol;

    /**
     * Constructor.
     *
     * @param actionsFunction a function that lists the legal actions from a state.
     * @param noneAction      an action representing None, i.e. a NoOp.
     * @param alpha           a fixed learning rate.
     * @param gamma           discount to be used.
     * @param Ne              is fixed parameter for use in the method f(u, n).
     * @param Rplus           R+ is an optimistic estimate of the best possible reward
     */
    public TicTacToeQLearningAgent(ActionsFunction<Grid, TicTacToeAction> actionsFunction, TicTacToeAction noneAction, double alpha, double gamma, int Ne, double Rplus, Grid grid, String name, String symbol) {
        super(actionsFunction, noneAction, alpha, gamma, Ne, Rplus);
        this.grid=grid;
        this.symbol=symbol;
        this.name=name;
    }

    void play() {
        //System.out.println("Agent "+ name + ", you play. Which cell do you choose?");
        PerceptStateReward percept = new TicTacToePercept(grid, symbol);
        TicTacToeAction action = execute(percept);
        if (action!=null){
            grid.put(action.getCell_number(), symbol);
        }
    }
}
