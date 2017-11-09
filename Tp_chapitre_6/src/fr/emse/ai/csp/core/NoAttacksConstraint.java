package fr.emse.ai.csp.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a binary constraint which forbids equal values.
 *
 * @author Ruediger Lunde
 */
public class NoAttacksConstraint implements Constraint {

    private Variable var1;
    private Variable var2;
    private int i1;
    private int i2;
    private List<Variable> scope;

    public NoAttacksConstraint(Variable var1, int i1, Variable var2, int i2) {
        this.var1 = var1;
        this.var2 = var2;
        this.i1=i1;
        this.i2=i2;
        scope = new ArrayList<Variable>(2);
        scope.add(var1);
        scope.add(var2);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        Object value1 = assignment.getAssignment(var1);
        Object value2 = assignment.getAssignment(var2);
        return value1 == null || value2 == null || !(value1.equals(assignment.getAssignment(var2)) || Math.abs(i2-i1)-Math.abs((int) value1-(int) value2)==0);
    }
}
