
import aima.core.probability.mdp.ActionsFunction;

import java.util.LinkedHashSet;
import java.util.Set;

public class TicTacToeActionsFunction implements ActionsFunction<Grid,TicTacToeAction> {

    @Override
    public Set<TicTacToeAction> actions(Grid grid) {
        Set<TicTacToeAction> _actions = new LinkedHashSet<TicTacToeAction>();
        if (!grid.isWon() && !grid.isFull()){
            for (int i = 1; i < 10; i++) {
                if (grid.isEmptyCell(i)){
                    _actions.add(new TicTacToeAction(i));
                }
            }
        }
        return _actions;
    }
}
