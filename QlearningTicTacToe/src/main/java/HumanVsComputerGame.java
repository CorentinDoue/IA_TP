import aima.core.probability.mdp.ActionsFunction;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class HumanVsComputerGame {
    /**
     * At first, we tried to make 2 QLearningAgent learn by fighting each other. It was not efficient
     * We created a RandomAgent which play randomly. We made the 2 QLearningAgent learn by fighting with the RandomAgent and then fight each other.
     * But as they are trained they did lot of draw and they unlearned.
     * So the most efficient is to learn by fighting with a RandomAgent.
     *
     */
    public static void main(String[] args) {
        boolean continu =true;
        Grid g = new Grid();
        TicTacToeActionsFunction af = new TicTacToeActionsFunction();

        TicTacToeQLearningAgent qla1 = new TicTacToeQLearningAgent(af,new TicTacToeAction(-1), 0.3, 0.8, 5, 1.0, g, "ql 1", "X");
        TicTacToeQLearningAgent qla2 = new TicTacToeQLearningAgent(af,new TicTacToeAction(-1), 0.3, 0.8, 5, 1.0, g, "ql 2", "O");
        RandomAgent ra1= new RandomAgent(g,"random 1","O");
        RandomAgent ra2= new RandomAgent(g,"random 1","X");
        int tour=0;
        for (int i = 0; i < 10000; i++) {
            System.out.println("Aléatoire n°"+i);

            while(!g.isWon()&&!g.isFull()){

                //System.out.println(g);
                if(tour==0)
                    qla1.play();
                else ra1.play();
                tour = 1-tour;
            }
            qla1.play();
            g.reset();


            while(!g.isWon()&&!g.isFull()){
                //System.out.println(g);
                if(tour==0)
                    qla2.play();
                else ra2.play();
                tour = 1-tour;
            }
            qla2.play();
            g.reset();
//            System.out.println(g);
//            System.out.println("Bravo ! Game over !!");
        }

        int vX = 0;
        int vO = 0;
        int draw = 0;

        for (int i = 0; i < 1; i++) {
            System.out.println("Adversial n°"+i);

            do
            {//System.out.println(g);
                if(tour==0)
                    qla1.play();
                else qla2.play();
                tour = 1-tour;
            }while(!g.isWon()&&!g.isFull());
            if (g.isFull()&&!g.isWon()){
                draw++;
                System.out.println("Draw");
            }else if(tour==0) {
                vX++;
                System.out.println("X won");
            } else {
                vO++;
                System.out.println("O won");
            }
            qla1.play();
            qla2.play();

            g.reset();

//            System.out.println(g);
//            System.out.println("Bravo ! Game over !!");
        }

        System.out.println("Total Draw : "+draw );
        System.out.println("Total X won : "+vX);
        System.out.println("Total O won : "+vO);



        Agent agent2 = new HumanAgent(g, "user", "O");
        tour=0;
        while (continu){
            while(!g.isWon()&&!g.isFull()&&continu)
            {
                System.out.println(g);
                if(tour==0)
                    qla1.play();
                else continu=agent2.play();
                tour = 1-tour;
            }
            qla1.play();
            if (continu && g.isFull()&&!g.isWon()){
                System.out.println(g);
                System.out.println("Draw");
                continu = cont();
            }else if(continu && tour==0) {
                System.out.println(g);
                System.out.println("You won ! Bravo !!");
                continu = cont();
            } else if (continu){
                System.out.println(g);
                System.out.println("Game over !!");
                continu = cont();
            }
            if (!continu)System.out.println("-- Game interrupted --");
            g.reset();
        }





    }

    private static boolean cont (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue, -1 to exit game");
        String result = sc.nextLine();
        int x=0;
        try{
            x=Integer.parseInt(result);
            if (x==-1){
                return false;
            }
        }catch(NumberFormatException e){
            return true;
        }
        return true;
    }
}