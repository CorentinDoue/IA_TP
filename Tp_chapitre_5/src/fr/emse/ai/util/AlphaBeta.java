package fr.emse.ai.util;


import java.util.ArrayList;

public class AlphaBeta {

    public static int minimax(SimpleTwoPlyGameTree Tree) {
        int minimax = maxvalue(Tree,Integer.MIN_VALUE, Integer.MAX_VALUE);

        return minimax;
    }

    private static int minvalue (SimpleTwoPlyGameTree Tree , int alpha, int beta){
        if (Tree.isLeaf()){
            System.out.println("explored : "+Tree.getValue());
            return (int)Tree.getValue();
        }else{
            int min = (int)Tree.getValue();
            ArrayList<SimpleTwoPlyGameTree> children = Tree.getChildren();
            for (SimpleTwoPlyGameTree child : children ) {
                int max = maxvalue(child,alpha,beta);
                if (min > max){
                    min = max;
                }
                if (min <= alpha){
                    Tree.setValue(min);
                    return min;
                }
                if (min < beta){
                    beta = min;
                }
            }
            Tree.setValue(min);
            return min;
        }
    }

    private static int maxvalue (SimpleTwoPlyGameTree Tree, int alpha, int beta){
        if (Tree.isLeaf()){
            System.out.println("explored : "+Tree.getValue());
            return (int)Tree.getValue();
        }else{
            int max = (int)Tree.getValue();
            ArrayList<SimpleTwoPlyGameTree> children = Tree.getChildren();
            for (SimpleTwoPlyGameTree child : children ) {
                int min = minvalue(child,alpha,beta);
                if (max < min){
                    max = min;
                }
                if (max >= beta){
                    Tree.setValue(max);
                    return max;
                }
                if (max > alpha){
                    alpha = max;
                }
            }
            Tree.setValue(max);
            return max;
        }
    }

}
