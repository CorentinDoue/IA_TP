package fr.emse.ai.adversarial.TicTacToe;

import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGameplay {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        MinimaxSearch<Integer[][], Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<Integer[][], Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<Integer[][], Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -6, 6, 10);
        Integer[][] state = game.getInitialState();
        while (!game.isTerminal(state)) {
            System.out.println("======================");
            printState(state);
            int action = 0;
            if (game.getPlayer(state) == 0) {
                //human
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("Human player, what is your action?");
                    System.out.println("(Entrez le numéro de la case selon l'ordre lexicographique entre 1 et 9)");
                    action = in.nextInt();
                }
            } else {
                //machine
                System.out.println("Machine player, what is your action?");
                //action = minimaxSearch.makeDecision(state);
                //System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                //alphabetaSearch.makeDecision(state);
                //System.out.println("Metrics for AlphaBeta : " + alphabetaSearch.getMetrics());
                action = iterativeDeepeningAlphaBetaSearch.makeDecision(state);
                System.out.println("Metrics for IDAlphaBetaSearch : " + iterativeDeepeningAlphaBetaSearch.getMetrics());
            }
            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
        }
        System.out.print("GAME OVER: ");
        System.out.println("======================");
        printState(state);
        if (game.isWon(state)) {
            if (game.getPlayer(state) == 1)
                System.out.println("Human wins!");
            else if (game.getPlayer(state) == 0)
                System.out.println("Machine wins!");
        }
        else {System.out.println("It s a tie");}

    }

    public static void printState(Integer[][] state) {
        for(int i = 0; i<3;i++){
            System.out.print('|');
            for(int j=0;j<3;j++){
                if(state[i][j]==-1) {
                    System.out.print("O|");
                }
                else if(state[i][j]==0){
                    System.out.print(" |");
                }
                else if(state[i][j]==1){
                    System.out.print("X|");
                }
            }
            System.out.println(' ');
        }

    }
}