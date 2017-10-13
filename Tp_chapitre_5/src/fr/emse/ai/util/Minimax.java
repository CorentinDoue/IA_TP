package fr.emse.ai.util;
/*
 * <pre>
 * <code>
 * function MINIMAX-DECISION(state) returns an action
         *   return argmax_[a in ACTIONS(s)] MIN-VALUE(RESULT(state, a))
         *
         * function MAX-VALUE(state) returns a utility value
         *   if TERMINAL-TEST(state) then return UTILITY(state)
         *   v = -infinity
         *   for each a in ACTIONS(state) do
         *     v = MAX(v, MIN-VALUE(RESULT(s, a)))
         *   return v
         *
         * function MIN-VALUE(state) returns a utility value
         *   if TERMINAL-TEST(state) then return UTILITY(state)
         *     v = infinity
         *     for each a in ACTIONS(state) do
         *       v  = MIN(v, MAX-VALUE(RESULT(s, a)))
         *   return v
         * </code>
        * </pre>
*/

import java.util.ArrayList;

public class Minimax {

    public static int minimax(SimpleTwoPlyGameTree Tree) {
        int minimax = maxvalue(Tree);

        return minimax;
    }

    private static int minvalue (SimpleTwoPlyGameTree Tree){
        if (Tree.isLeaf()){
            System.out.println("explored : "+Tree.getValue());
            return (int)Tree.getValue();
        }else{
            int min = (int)Tree.getValue();
            ArrayList<SimpleTwoPlyGameTree> children = Tree.getChildren();
            for (SimpleTwoPlyGameTree child : children ) {
                int max = maxvalue(child);
                if (min > max){
                    min = max;
                }
            }
            Tree.setValue(min);
            return min;
        }
    }

    private static int maxvalue (SimpleTwoPlyGameTree Tree){
        if (Tree.isLeaf()){
            System.out.println("explored : "+Tree.getValue());
            return (int)Tree.getValue();
        }else{
            int max = (int)Tree.getValue();
            ArrayList<SimpleTwoPlyGameTree> children = Tree.getChildren();
            for (SimpleTwoPlyGameTree child : children ) {
                int min = minvalue(child);
                if (max < min){
                    max = min;
                }
            }
            Tree.setValue(max);
            return max;
        }
    }

}
