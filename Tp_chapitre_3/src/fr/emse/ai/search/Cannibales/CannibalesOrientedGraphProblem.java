package fr.emse.ai.search.Cannibales;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class CannibalesOrientedGraphProblem implements Problem {

    CannibalesState initialState = new CannibalesState(CannibalesState.MMMD);
    CannibalesState finalState = new CannibalesState(CannibalesState.CCCG);

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
        String s = ((CannibalesState) state).value;
        if (s.equals(CannibalesState.MMMD)) {
            actions.add("go to MMMCG");
            actions.add("go to MMMCCG");
        } else if (s.equals(CannibalesState.MMMCG)) {
            actions.add("go to MMMD");
            actions.add("go to MCD");
        } else if (s.equals(CannibalesState.MCD)) {
            actions.add("go to MMMCG");
            actions.add("go to MMCCG");
        } else if (s.equals(CannibalesState.MMCCG)) {
            actions.add("go to MCD");
            actions.add("go to CCD");
        } else if (s.equals(CannibalesState.CCD)) {
            actions.add("go to MMCCG");
            actions.add("go to CCCG");
        } else if (s.equals(CannibalesState.CCCG)) {
            actions.add("go to CCD");
        } else if (s.equals(CannibalesState.MMMCCG)) {
            actions.add("go to MMMD");
            actions.add("go to MMCCD");
            actions.add("go to MMMCD");
        } else if (s.equals(CannibalesState.MMCCD)) {
            actions.add("go to MMMCCG");
            actions.add("go to MMMCCCG");
        } else if (s.equals(CannibalesState.MMMCD)) {
            actions.add("go to MMMCCG");
            actions.add("go to MMMCCCG");
        } else if (s.equals(CannibalesState.MMMCCCG)) {
            actions.add("go to MMCCD");
            actions.add("go to MMMCD");
            actions.add("go to MMMCCD");
        } else if (s.equals(CannibalesState.MMMCCD)) {
            actions.add("go to MMMCCCG");
        }

        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to MMMD")) return new CannibalesState(CannibalesState.MMMD);
        if (action.equals("go to MMMCG")) return new CannibalesState(CannibalesState.MMMCG);
        if (action.equals("go to MCD")) return new CannibalesState(CannibalesState.MCD);
        if (action.equals("go to MMCCG")) return new CannibalesState(CannibalesState.MMCCG);
        if (action.equals("go to CCD")) return new CannibalesState(CannibalesState.CCD);
        if (action.equals("go to CCCG")) return new CannibalesState(CannibalesState.CCCG);
        if (action.equals("go to MMMCCG")) return new CannibalesState(CannibalesState.MMMCCG);
        if (action.equals("go to MMCCD")) return new CannibalesState(CannibalesState.MMCCD);
        if (action.equals("go to MMMCD")) return new CannibalesState(CannibalesState.MMMCD);
        if (action.equals("go to MMMCCCG")) return new CannibalesState(CannibalesState.MMMCCCG);
        if (action.equals("go to MMMCCD")) return new CannibalesState(CannibalesState.MMMCCD);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
