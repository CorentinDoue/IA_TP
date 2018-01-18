import aima.core.learning.reinforcement.PerceptStateReward;

public class TicTacToePercept implements PerceptStateReward<Grid> {
    private Grid grid;
    private String symbol;

    public TicTacToePercept(Grid grid, String symbol) {
        this.grid = grid;
        this.symbol = symbol;
    }

    @Override
    public Grid state() {
        return grid.copy();
    }

    @Override
    public double reward() {
        if (grid.isWon()) {
            if (grid.getCell(1) == symbol && grid.getCell(2) == symbol && grid.getCell(3) == symbol ||
                    grid.getCell(4) == symbol && grid.getCell(5) == symbol && grid.getCell(6) == symbol ||
                    grid.getCell(7) == symbol && grid.getCell(8) == symbol && grid.getCell(9) == symbol ||
                    grid.getCell(1) == symbol && grid.getCell(4) == symbol && grid.getCell(7) == symbol ||
                    grid.getCell(2) == symbol && grid.getCell(5) == symbol && grid.getCell(8) == symbol ||
                    grid.getCell(3) == symbol && grid.getCell(6) == symbol && grid.getCell(9) == symbol ||
                    grid.getCell(1) == symbol && grid.getCell(5) == symbol && grid.getCell(9) == symbol ||
                    grid.getCell(3) == symbol && grid.getCell(5) == symbol && grid.getCell(7) == symbol
                    ) return 1;
            return -1;
//        }else if (grid.isFull()){
//            return 0;
//        }
//        return 0.5;
        }else {
            return 0;
        }
    }
}
