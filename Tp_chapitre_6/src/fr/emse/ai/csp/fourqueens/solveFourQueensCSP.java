package fr.emse.ai.csp.fourqueens;


import fr.emse.ai.csp.australia.MapCSP;
import fr.emse.ai.csp.core.Assignment;
import fr.emse.ai.csp.core.BacktrackingStrategy;
import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.CSPStateListener;

public class solveFourQueensCSP {
    public static void main(String[] args) {
        FourQueensCSP map = new FourQueensCSP();
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
