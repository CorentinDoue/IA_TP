package fr.emse.ai.csp.nqueens;


import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.BacktrackingStrategy;
import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.CSPStateListener;
import fr.emse.ai.csp.fourqueens.FourQueensCSP;

import java.util.Scanner;

public class solveNQueensCSP {
    public static void main(String[] args) {
        System.out.println("N Queens problem");
        Scanner in = new Scanner(System.in);
        int N = 0;
        while (N<1) {
            System.out.println("What is the value of N ?");
            N = in.nextInt();
        }
        NQueensCSP map = new NQueensCSP(N);
        BacktrackingStrategy bts = new BacktrackingStrategy();
        bts.addCSPStateListener(new CSPStateListener() {
            @Override
            public void stateChanged(Assignment assignment, CSP csp) {
                System.out.println("Assignment evolved : " + assignment);
            }

            @Override
            public void stateChanged(CSP csp) {
                System.out.println("CSP evolved : " + csp);
            }
        });
        double start = System.currentTimeMillis();
        Assignment sol = bts.solve(map);
        double end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve = " + (end - start));
    }
}
