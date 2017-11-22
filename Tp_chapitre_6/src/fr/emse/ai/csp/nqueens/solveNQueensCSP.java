package fr.emse.ai.csp.nqueens;


import fr.emse.ai.csp.core.*;
import fr.emse.ai.csp.fourqueens.FourQueensCSP;
import jdk.nashorn.internal.ir.Assignment;

import java.util.Scanner;

public class solveNQueensCSP {
    public static void main(String[] args) {
        double start;
        double end;
        fr.emse.ai.csp.core.Assignment sol;
        System.out.println("N Queens problem");
        Scanner in = new Scanner(System.in);
        int N = 0;
        while (N<1) {
            System.out.println("What is the value of N ?");
            N = in.nextInt();
        }
        NQueensCSP map = new NQueensCSP(N);
        //Backtracking
        //BacktrackingStrategy bts = new BacktrackingStrategy();
//        bts.addCSPStateListener(new CSPStateListener() {
//            @Override
//            public void stateChanged(Assignment assignment, CSP csp) {
//                System.out.println("Assignment evolved : " + assignment);
//            }
//
//            @Override
//            public void stateChanged(CSP csp) {
//                System.out.println("CSP evolved : " + csp);
//            }
//        });
//        start = System.currentTimeMillis();
//        Assignment sol = bts.solve(map);
//        double end = System.currentTimeMillis();
//        System.out.println(sol);
//        System.out.println("Time to solve Backtracking = " + (end - start));
        //Min-conflicts
        map = new NQueensCSP(N);
        MinConflictsStrategy mcs = new MinConflictsStrategy(100000);
//        mcs.addCSPStateListener(new CSPStateListener() {
//            @Override
//            public void stateChanged(Assignment assignment, CSP csp) {
//                System.out.println("Assignment evolved : " + assignment);
//            }
//
//            @Override
//            public void stateChanged(CSP csp) {
//                System.out.println("CSP evolved : " + csp);
//            }
//        });
        start = System.currentTimeMillis();
        sol = mcs.solve(map);
        end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve min-conflicts= " + (end - start));
        /* We noticed the min-conflicts strategy is always faster than the backtracking strategy
        and the more the value of N we increase the bigger the gap is.
        For exemple for N=16 :
            Backtracking strategy : 1603ms
            Minconflicts strategy : 5ms
        For N=20 :
            Backtracking strategy : 36034ms
            Minconflicts strategy : 18ms
         */
        /*We add the AC-3 algorithm in the backtracking strategy to reduce the domain :
        The backtracking strategy is more efficient, it's 10 time faster
        For exemple for N=16 :
            Backtracking strategy : 338ms
            Minconflicts strategy : 6ms
        For N=20 :
            Backtracking strategy : 2938ms
            Minconflicts strategy : 14ms
         */
        //Backtracking with MRV
        map = new NQueensCSP(N);
        BacktrackingStrategy btsmrv = new BacktrackingStrategy(true,1);
//        btsmrv.addCSPStateListener(new CSPStateListener() {
//            @Override
//            public void stateChanged(Assignment assignment, CSP csp) {
//                System.out.println("Assignment evolved : " + assignment);
//            }
//
//            @Override
//            public void stateChanged(CSP csp) {
//                System.out.println("CSP evolved : " + csp);
//            }
//        });
        start = System.currentTimeMillis();
        sol = btsmrv.solve(map);
        end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve Backtracking with MRV= " + (end - start));
        //Backtracking with MRV and DH
        map = new NQueensCSP(N);
        BacktrackingStrategy btsmrvdh = new BacktrackingStrategy(true,2);
//        btsmrvdh.addCSPStateListener(new CSPStateListener() {
//            @Override
//            public void stateChanged(Assignment assignment, CSP csp) {
//                System.out.println("Assignment evolved : " + assignment);
//            }
//
//            @Override
//            public void stateChanged(CSP csp) {
//                System.out.println("CSP evolved : " + csp);
//            }
//        });
        start = System.currentTimeMillis();
        sol = btsmrvdh.solve(map);
        end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve Backtracking with MRV and DH = " + (end - start));
        //Most efficient backtracking
        map = new NQueensCSP(N);
        BacktrackingStrategy mebts = new BacktrackingStrategy(true,2,true);
//        mebts.addCSPStateListener(new CSPStateListener() {
//            @Override
//            public void stateChanged(Assignment assignment, CSP csp) {
//                System.out.println("Assignment evolved : " + assignment);
//            }
//
//            @Override
//            public void stateChanged(CSP csp) {
//                System.out.println("CSP evolved : " + csp);
//            }
//        });
        start = System.currentTimeMillis();
        sol = mebts.solve(map);
        end = System.currentTimeMillis();
        System.out.println(sol);
        System.out.println("Time to solve most efficient Backtracking = " + (end - start));
    }
}
