package fr.emse.ai.search.can;

import fr.emse.ai.search.core.Problem;


import java.util.ArrayList;
import java.util.Collection;

public class CanGraphProblem implements Problem {

    CanState initialState = new CanState(CanState.A);
    CanState finalState = new CanState(CanState.K);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return ((CanState) state).equals(finalState.value);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();

        if (((CanState) state).equals(CanState.A)) {
            actions.add("go to B");
            actions.add("go to D");
            actions.add("go to N");
            actions.add("go to M");
        } else if (((CanState) state).equals(CanState.B)) {
            actions.add("go to J");
            actions.add("go to C");
        } else if (((CanState) state).equals(CanState.C)) {
            actions.add("go to J");
            actions.add("go to B");
        } else if (((CanState) state).equals(CanState.D)) {
            actions.add("go to J");
            actions.add("go to E");
        } else if (((CanState) state).equals(CanState.E)) {
            actions.add("go to D");
            actions.add("go to F");
            actions.add("go to K");
        } else if (((CanState) state).equals(CanState.F)) {
            actions.add("go to J");
            actions.add("go to G");
        } else if (((CanState) state).equals(CanState.G)) {
            actions.add("go to K");
            actions.add("go to H");
            actions.add("go to F");
        } else if (((CanState) state).equals(CanState.H)) {
            actions.add("go to I");
            actions.add("go to J");
        } else if (((CanState) state).equals(CanState.J)) {

        } else if (((CanState) state).equals(CanState.K)) {
            actions.add("go to J");
            actions.add("go to L");
        } else if (((CanState) state).equals(CanState.L)) {
            actions.add("go to K");
            actions.add("go to J");
        } else if (((CanState) state).equals(CanState.M)) {
            actions.add("go to A");
            actions.add("go to J");
            actions.add("go to N");
        } else if (((CanState) state).equals(CanState.N)) {
            actions.add("go to O");
            actions.add("go to M");
            actions.add("go to K");
        } else if (((CanState) state).equals(CanState.O)) {
            actions.add("go to J");
            actions.add("go to P");
        } else if (((CanState) state).equals(CanState.P)) {
            actions.add("go to L");
            actions.add("go to K");
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to A")) return new CanState(CanState.A);
        if (action.equals("go to B")) return new CanState(CanState.B);
        if (action.equals("go to C")) return new CanState(CanState.C);
        if (action.equals("go to D")) return new CanState(CanState.D);
        if (action.equals("go to E")) return new CanState(CanState.E);
        if (action.equals("go to F")) return new CanState(CanState.F);
        if (action.equals("go to G")) return new CanState(CanState.G);
        if (action.equals("go to H")) return new CanState(CanState.H);
        if (action.equals("go to I")) return new CanState(CanState.I);
        if (action.equals("go to J")) return new CanState(CanState.J);
        if (action.equals("go to K")) return new CanState(CanState.K);
        if (action.equals("go to L")) return new CanState(CanState.L);
        if (action.equals("go to M")) return new CanState(CanState.M);
        if (action.equals("go to N")) return new CanState(CanState.N);
        if (action.equals("go to O")) return new CanState(CanState.O);
        if (action.equals("go to P")) return new CanState(CanState.P);

        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
