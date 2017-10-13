package fr.emse.ai.util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SimpleTwoPlyGameTree tree1 = new SimpleTwoPlyGameTree(Integer.MIN_VALUE, true);
        ArrayList<SimpleTwoPlyGameTree<Integer>> sublist1 = new ArrayList<SimpleTwoPlyGameTree<Integer>>();
        sublist1.add(new SimpleTwoPlyGameTree<Integer>(3,true));
        sublist1.add(new SimpleTwoPlyGameTree<Integer>(12,true));
        sublist1.add(new SimpleTwoPlyGameTree<Integer>(8,true));
        SimpleTwoPlyGameTree<Integer> subtree1 = new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE,false,sublist1);
        ArrayList<SimpleTwoPlyGameTree<Integer>> sublist2 = new ArrayList<SimpleTwoPlyGameTree<Integer>>();
        sublist2.add(new SimpleTwoPlyGameTree<Integer>(2,true));
        sublist2.add(new SimpleTwoPlyGameTree<Integer>(4,true));
        sublist2.add(new SimpleTwoPlyGameTree<Integer>(6,true));
        SimpleTwoPlyGameTree<Integer> subtree2 = new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE,false,sublist2);
        ArrayList<SimpleTwoPlyGameTree<Integer>> sublist3 = new ArrayList<SimpleTwoPlyGameTree<Integer>>();
        sublist3.add(new SimpleTwoPlyGameTree<Integer>(14,true));
        sublist3.add(new SimpleTwoPlyGameTree<Integer>(5,true));
        sublist3.add(new SimpleTwoPlyGameTree<Integer>(2,true));
        SimpleTwoPlyGameTree<Integer> subtree3 = new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE,false,sublist3);
        tree1.addChild(subtree1);
        tree1.addChild(subtree2);
        tree1.addChild(subtree3);
        String str = tree1.toString();
        System.out.println(str);
        int minimax = Minimax.minimax(tree1);
        System.out.println("Minmax value : "+minimax);
        int alphabeta = AlphaBeta.minimax(tree1);
        System.out.println("Alphabeta value : "+alphabeta);
    }
}
