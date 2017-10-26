package fr.emse.ai.adversarial.ConnectFour;

import fr.emse.ai.adversarial.Game;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame implements Game<ArrayList<ArrayList<Boolean>>, Integer, Integer> {

    public final static Integer[] players = {0, 1};
    public final static ArrayList<ArrayList<Boolean>> initialState = new ArrayList<ArrayList<Boolean>>();

    public ConnectFourGame(){
        ArrayList<Boolean> C0 = new ArrayList<Boolean>();
        for (int i = 0; i < 7; i++) {
            initialState.add(C0);
        }


    }

    @Override
    public ArrayList<ArrayList<Boolean>> getInitialState() {
        return initialState;
    }

    @Override
    public Integer[] getPlayers() {
        return players;
    }

    @Override
    public Integer getPlayer(ArrayList<ArrayList<Boolean>> state) {
        int count=0;
        for (ArrayList<Boolean> column:state) {
            for (Boolean piece:column) {
                count++;
            }
        }
        return count % 2;
    }

    @Override
    public List<Integer> getActions(ArrayList<ArrayList<Boolean>> state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++)
            if (state.get(i).size()<7){
                actions.add(i);
            }
        return actions;
    }

    @Override
    public ArrayList<ArrayList<Boolean>> getResult(ArrayList<ArrayList<Boolean>> state, Integer action) {
        ArrayList<ArrayList<Boolean>> newState = new ArrayList<ArrayList<Boolean>>(state);
        ArrayList<Boolean> newColumn = new ArrayList<>(state.get(action));
        if (getPlayer(state)==1) {
            newColumn.add(true);
        }else{
            newColumn.add(false);
        }
        newState.set(action,newColumn);
        return newState;
    }

    @Override
    public boolean isTerminal(ArrayList<ArrayList<Boolean>> state) {

        for (int i = 0; i < 4; i++) {
            int count =0;
            for (int j = 0; j < state.get(i).size(); j++) {
                if (checkVoisins(state, i, j, 1, -1)==state.get(i).get(j) || checkVoisins(state, i, j, 1, 0)==state.get(i).get(j) || checkVoisins(state, i, j, 1, 1)==state.get(i).get(j))
                    return true;
                if (j>0 && state.get(i).get(j)==state.get(i).get(j-1)){
                    if (count==2){
                        return true;
                    }else{
                        count++;
                    }
                }else{
                    count=0;
                }
            }
        }
        return false;
    }

    private boolean checkVoisins(ArrayList<ArrayList<Boolean>> state, int i, int j, int deep, int dir){
        if (i<6){
            if (j+dir >= 0 && j+dir < state.get(i+1).size()){
                if (state.get(i).get(j)==state.get(i+1).get(j+dir)){
                    if (deep==3)
                        return state.get(i).get(j);
                    else
                        return checkVoisins(state,i+1, j+dir, deep+1, dir);
                }else{
                    return !state.get(i).get(j);
                }
            }else{
                return !state.get(i).get(j);
            }
        }else{
            return !state.get(i).get(j);
        }
    }

    @Override
    public double getUtility(ArrayList<ArrayList<Boolean>> state, Integer player) {
        if (getPlayer(state)==player) {
                return -1;
        } else {
                return 1;
        }
    }
}
