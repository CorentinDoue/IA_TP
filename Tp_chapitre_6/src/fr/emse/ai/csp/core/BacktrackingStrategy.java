package fr.emse.ai.csp.core;

import fr.emse.ai.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.5, Page 215.<br>
 * <br>
 * <p/>
 * <pre>
 * <code>
 * function BACKTRACKING-SEARCH(csp) returns a solution, or failure
 *    return BACKTRACK({ }, csp)
 *
 * function BACKTRACK(assignment, csp) returns a solution, or failure
 *    if assignment is complete then return assignment
 *    var = SELECT-UNASSIGNED-VARIABLE(csp)
 *    for each value in ORDER-DOMAIN-VALUES(var, assignment, csp) do
 *       if value is consistent with assignment then
 *          add {var = value} to assignment
 *          inferences = INFERENCE(csp, var, value)
 *          if inferences != failure then
 *             add inferences to assignment
 *             result = BACKTRACK(assignment, csp)
 *             if result != failure then
 *                return result
 *          remove {var = value} and inferences from assignment
 *    return failure
 * </code>
 * </pre>
 * <p/>
 * Figure 6.5 A simple backtracking algorithm for constraint satisfaction
 * problems. The algorithm is modeled on the recursive depth-first search of
 * Chapter 3. By varying the functions SELECT-UNASSIGNED-VARIABLE and
 * ORDER-DOMAIN-VALUES, we can implement the general-purpose heuristic discussed
 * in the text. The function INFERENCE can optionally be used to impose arc-,
 * path-, or k-consistency, as desired. If a value choice leads to failure
 * (noticed wither by INFERENCE or by BACKTRACK), then value assignments
 * (including those made by INFERENCE) are removed from the current assignment
 * and a new value is tried.
 *
 * @author Ruediger Lunde
 */
public class BacktrackingStrategy extends SolutionStrategy {
    boolean allowAC3=false;
    int variableHeuristic;
    boolean allowLCV=false;


    public BacktrackingStrategy(){
        variableHeuristic=0;
    }

    public BacktrackingStrategy(boolean allowAC3){
        this.allowAC3=allowAC3;
        variableHeuristic=0;

    }

    public BacktrackingStrategy(int i){
        variableHeuristic=i;
    }

    public BacktrackingStrategy(boolean allowAC3, int i){
        variableHeuristic=i;
        this.allowAC3=allowAC3;

    }

    public BacktrackingStrategy(boolean allowAC3, int i, boolean allowLCV){
        variableHeuristic=i;
        this.allowAC3=allowAC3;
        this.allowLCV=allowLCV;
    }

    public Assignment solve(CSP csp) {
        return recursiveBackTrackingSearch(csp, new Assignment());
    }

    /**
     * Template method, which can be configured by overriding the three
     * primitive operations below.
     */
    private Assignment recursiveBackTrackingSearch(CSP csp,Assignment assignment) {
        Assignment result = null;
        if (assignment.isComplete(csp.getVariables())) {
            result = assignment;
        } else {
            Variable var = selectUnassignedVariable(assignment, csp);
            for (Object value : orderDomainValues(var, assignment, csp)) {
                assignment.setAssignment(var, value);
                if (assignment.isConsistent(csp.getConstraints(var))) {
                    DomainRestoreInfo info = inference(var, assignment, csp);
                    if (!info.isEmpty())
                        fireStateChanged(csp);
                    if (!info.isEmptyDomainFound()) {
                        result = recursiveBackTrackingSearch(csp, assignment);
                        if (result != null)
                            break;
                    }
                    info.restoreDomains(csp);
                }
                assignment.removeAssignment(var);
            }
        }
        return result;
    }

    /**
     * Primitive operation, selecting a not yet assigned variable. This default
     * implementation just selects the first in the ordered list of variables
     * provided by the CSP.
     */
    protected Variable selectUnassignedVariable(Assignment assignment, CSP csp) {
        if (variableHeuristic==1) {
            return MRV(assignment, csp);
        }else if (variableHeuristic==2){
            return MRV_DH(assignment, csp);
        }else{
            return firstInList(assignment, csp);
        }
    }


    private Variable firstInList(Assignment assignment, CSP csp){
        for (Variable var : csp.getVariables()) {
            if (!(assignment.hasAssignmentFor(var)))
                return var;
        }
        return null;
    }

    private Variable MRV(Assignment assignment, CSP csp) {
        Variable minvar = null;
        Double minvalue=Double.POSITIVE_INFINITY;;
        Domain dom;
        boolean allAssigned=true;
        for (Variable var : csp.getVariables()) {
            if (!(assignment.hasAssignmentFor(var))) {
                dom = csp.getDomain(var);
                if (dom.size() < minvalue) {
                    minvar=var;
                    minvalue=(double)dom.size();
                }
                allAssigned=false;
            }
        }
        if (allAssigned){
            return null;
        }else{
            return minvar;
        }
    }

    private Variable MRV_DH(Assignment assignment, CSP csp) {
        ArrayList<Variable> minvars = new ArrayList<>();
        Double minvalue=Double.POSITIVE_INFINITY;
        int maxconstraint = 0;
        Domain dom;
        List<Constraint> constraints;
        Variable maxvar =null;
        boolean allAssigned=true;
        for (Variable var : csp.getVariables()) {
            if (!(assignment.hasAssignmentFor(var))) {
                dom = csp.getDomain(var);
                if (dom.size() < minvalue) {
                    minvars.clear();
                    minvars.add(var);
                    minvalue=(double)dom.size();
                }else if ((double)dom.size() == minvalue){
                    minvars.add(var);
                }
                allAssigned=false;
            }
        }
        if (allAssigned){
            return null;
        }else{
            for (Variable var: minvars) {
                constraints = csp.getConstraints(var);
                if (constraints.size()>maxconstraint){
                    maxvar=var;
                    maxconstraint=constraints.size();
                }
            }
            return maxvar;
        }
    }

    /**
     * Primitive operation, ordering the domain values of the specified
     * variable. This default implementation just takes the default order
     * provided by the CSP.
     */
    protected Iterable<?> orderDomainValues(Variable var, Assignment assignment, CSP csp) {
        if (allowLCV){
            int sum;
            List<Pair<Object,Integer>> sums = new ArrayList<>();
            for (Object value:csp.getDomain(var)) {
                sum=0;
                Assignment assignment2 = new Assignment();
                assignment2.setAssignment(var, value);
                for (Constraint constraint : csp.getConstraints(var)) {
                    Variable neighbor = csp.getNeighbor(var, constraint);
                    for (Object nValue : csp.getDomain(neighbor)) {
                        assignment2.setAssignment(neighbor, nValue);
                        if (!constraint.isSatisfiedWith(assignment)) {
                            ++sum;
                        }
                    }
                }
                sums.add(new Pair(value,sum));
            }
            List<Object> values = new ArrayList<>();
            Comparator<Pair> comparator = (o1, o2) -> (int)o2.getSecond()-(int)o1.getSecond();
            sums.sort(comparator);
            for (Pair<Object,Integer> pair:sums) {
                values.add(pair.getFirst());
            }
            return values;
        }else{
            return csp.getDomain(var);
        }
    }

    /**
     * Primitive operation, which tries to prune out values from the CSP which
     * are not possible anymore when extending the given assignment to a
     * solution. This default implementation just leaves the original CSP as it
     * is.
     *
     * @return An object which provides informations about (1) whether changes
     * have been performed, (2) possibly inferred empty domains , and
     * (3) how to restore the domains.
     */
    protected DomainRestoreInfo inference(Variable var, Assignment assignment, CSP csp) {
        if (allowAC3) {
            AC3Strategy ac3 = new AC3Strategy();
            Object value = assignment.getAssignment(var);
            return ac3.reduceDomains(var, value, csp);
        }else {
            return new DomainRestoreInfo().compactify();
        }
    }
}
