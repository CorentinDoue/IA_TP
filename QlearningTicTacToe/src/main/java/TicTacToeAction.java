import aima.core.agent.Action;
import aima.core.environment.cellworld.CellWorldAction;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TicTacToeAction implements Action {
    private int cell_number;


    public  TicTacToeAction(int cell_number) {
        if (cell_number > 0 && cell_number < 10) {
            this.cell_number = cell_number;
        }else {
            this.cell_number = -1;
        }

    }

    public int getCell_number(){
        return cell_number;
    }

    @Override
    public boolean isNoOp() {
        return cell_number == -1;
    }

    @Override
    public String toString() {
        return "TicTacToeAction{" +
                "cell_number=" + cell_number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToeAction that = (TicTacToeAction) o;
        return cell_number == that.cell_number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(cell_number);
    }
}
