package fr.emse.ai.adversarial.ConnectFour;

import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;
import fr.emse.ai.adversarial.nim.NimGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectFourGameplay {

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        MinimaxSearch<ArrayList<ArrayList<Boolean>>, Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<ArrayList<ArrayList<Boolean>>, Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<ArrayList<ArrayList<Boolean>>, Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -10, 10, 10);
        ArrayList<ArrayList<Boolean>> state = game.getInitialState();
        while (!game.isTerminal(state)) {
            System.out.println("======================");
            System.out.println("_________________");
            String ligne;
            for (int j = 6; j >=0; j--) {
                ligne="|";
                for (ArrayList<Boolean> column:state) {
                    if (j<column.size()){
                        if (column.get(j))
                            ligne+=" X";
                        else
                            ligne+=" O";
                    }else
                        ligne+="  ";
                }
                ligne+=" |";
                System.out.println(ligne);
            }
            System.out.println("_________________");
            System.out.println("_ 0 1 2 3 4 5 6 _");

            int action = -1;
            if (game.getPlayer(state) == 0 && !game.isTerminal(state)) {
                //human
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("Human player, what is your action?");
                    action = in.nextInt();
                }
            } else if(!game.isTerminal(state)) {
                //machine
                System.out.println("Machine player, what is your action?");
                //action = minimaxSearch.makeDecision(state);
                //System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                //action=alphabetaSearch.makeDecision(state);
                //System.out.println("Metrics for AlphaBeta : " + alphabetaSearch.getMetrics());
                action = iterativeDeepeningAlphaBetaSearch.makeDecision(state);
                System.out.println("Metrics for IDAlphaBetaSearch : " + iterativeDeepeningAlphaBetaSearch.getMetrics());
            }
            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
        }
        System.out.print("GAME OVER: ");
        System.out.println("======================");
        System.out.println("_________________");
        String ligne;
        for (int j = 6; j >=0; j--) {
            ligne="|";
            for (ArrayList<Boolean> column:state) {
                if (j<column.size()){
                    if (column.get(j))
                        ligne+=" X";
                    else
                        ligne+=" O";
                }else
                    ligne+="  ";
            }
            ligne+=" |";
            System.out.println(ligne);
        }
        System.out.println("_________________");
        if (game.getPlayer(state) == 0)
            System.out.println("Machine wins!");
        else {
            if (game.getPlayer(state) == 2){
                System.out.println("Draw");
            }else{
                System.out.println("Human wins!");
            }

        }
    }
}
