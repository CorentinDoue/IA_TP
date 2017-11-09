package fr.emse.ai.csp.nqueens;


import fr.emse.ai.csp.core.CSP;
import fr.emse.ai.csp.core.Domain;
import fr.emse.ai.csp.core.NoAttacksConstraint;
import fr.emse.ai.csp.core.Variable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.1, Page 204.<br>
 * <br>
 * The principal states and territories of Australia. Coloring this map can be
 * viewed as a constraint satisfaction problem (CSP). The goal is to assign
 * colors to each region so that no neighboring regions have the same color.
 *
 * @author Ruediger Lunde
 * @author Mike Stampone
 */
public class NQueensCSP extends CSP {


    public ArrayList<Variable> variables = new ArrayList<>();

    /**
     * Constructs a map CSP for the principal states and territories of
     * Australia, with the colors Red, Green, and Blue.
     */
    public NQueensCSP(int n) {

        initVariables(n);
        collectVariables();

        Object[] values = new Object[]{};
        for (int i = 1; i < n+1; i++) {
            values=appendValue(values, i);
        }

        Domain positions = new Domain(values);

        for (Variable var : getVariables())
            setDomain(var, positions);

        for (int i = 0; i < variables.size(); i++) {
            for (int j = i+1; j < variables.size(); j++) {
                addConstraint(new NoAttacksConstraint(variables.get(i), i+1, variables.get(j),j+1));
            }
        }
    }

    /**
     * Returns the principle states and territories of Australia as a list of
     * variables.
     *
     * @return the principle states and territories of Australia as a list of
     * variables.
     */
    private void initVariables(int n){
        for (int i = 1; i < n+1; i++) {
            variables.add(new Variable("Queen_"+i));
        }

    }

    private void collectVariables() {
        for (int i = 0; i < variables.size(); i++) {
            addVariable(variables.get(i));
        }
    }

    private Object[] appendValue(Object[] obj, Object newObj) {

        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();

    }
}