package fr.emse.ai.search.farmer;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class FarmerOrientedGraphProblem implements Problem {

    FarmerState initialState = new FarmerState(FarmerState.AAAA);
    FarmerState finalState = new FarmerState(FarmerState.BBBB);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        String s = ((FarmerState) state).value;
        if (s.equals(FarmerState.AAAA)) {
            actions.add("go to BABA");
        } else if (s.equals(FarmerState.BABA)) {
            actions.add("go to AABA");
        } else if (s.equals(FarmerState.AABA)) {
            actions.add("go to BABB");
            actions.add("go to BBBA");
        } else if (s.equals(FarmerState.BABB)) {
            actions.add("go to AAAB");
        } else if (s.equals(FarmerState.AAAB)) {
            actions.add("go to BBAB");
        } else if (s.equals(FarmerState.BBBA)) {
            actions.add("go to ABAA");
        } else if (s.equals(FarmerState.ABAA)) {
            actions.add("go to BBAB");
        } else if (s.equals(FarmerState.BBAB)) {
            actions.add("go to ABAB");
        } else if (s.equals(FarmerState.ABAB)) {
            actions.add("go to BBBB");
        } else if (s.equals(FarmerState.BBBB)) {

        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to AAAA")) return new FarmerState(FarmerState.AAAA);
        if (action.equals("go to BABA")) return new FarmerState(FarmerState.BABA);
        if (action.equals("go to AABA")) return new FarmerState(FarmerState.AABA);
        if (action.equals("go to BABB")) return new FarmerState(FarmerState.BABB);
        if (action.equals("go to AAAB")) return new FarmerState(FarmerState.AAAB);
        if (action.equals("go to BBBA")) return new FarmerState(FarmerState.BBBA);
        if (action.equals("go to ABAA")) return new FarmerState(FarmerState.ABAA);
        if (action.equals("go to BBAB")) return new FarmerState(FarmerState.BBAB);
        if (action.equals("go to ABAB")) return new FarmerState(FarmerState.ABAB);
        if (action.equals("go to BBBB")) return new FarmerState(FarmerState.BBBB);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
