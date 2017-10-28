package fr.emse.ai.adversarial.TicTacToe;

import fr.emse.ai.adversarial.Game;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements Game<Integer[][], Integer, Integer> {

    public final static Integer[] players = {0, 1};
    public final static Integer[][] initialState = new Integer[3][3];

    public TicTacToeGame() {
        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
                initialState[i][j]=0;
            }
        }
    }

    @Override
    public Integer[][] getInitialState() {
        return initialState;
    }

    @Override
    public Integer[] getPlayers() {
        return players;
    }

    @Override
    public Integer getPlayer(Integer[][] state) {
        int count = 0;
        for (Integer sousTab[] : state){
            for(Integer k:sousTab){
                if(k!=0){count++;}
            }
        }
        return count % 2;

    }

    @Override
    public List<Integer> getActions(Integer[][] state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
                if(state[i][j]==0){
                    actions.add(3*i+j+1);
                }
            }
        }
        return actions;
    }

    @Override
    public Integer[][] getResult(Integer[][] state, Integer action) {
        Integer[][] newState = new Integer[3][3];
        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
                newState[i][j]=state[i][j];
            }
        }
        if (getPlayer(state)==0)
            newState[(action-1)/3][(action-1)%3]=-1;
        else if (getPlayer(state)==1)
            newState[(action-1)/3][(action-1)%3]=1;
        return newState;
    }

    @Override
    public boolean isTerminal(Integer[][] state) {
        return (isWon(state) || isFull(state));
    }



    @Override
    public double getUtility(Integer[][] state, Integer player) {

        if (isTerminal(state)) {
            if (getPlayer(state) == player) {
                return Double.NEGATIVE_INFINITY;
            } else {
                return Double.POSITIVE_INFINITY;
            }
        }else{
            if (getPlayer(state) == player) {
                return utility(state, player);
            }else{
                return -utility(state, player);
            }
        }
    }

    public double utility(Integer[][] state, Integer player) {
        double util = 0;
        if (player == 1) {
            for (int i = 0; i < 3; i++) {
                if (state[i][0] + state[i][1] + state[i][2] == -2)
                    util += 4;
                if (state[0][i] + state[1][i] + state[2][i] == -2)
                    util += 4;
                if (state[i][0] + state[i][1] + state[i][2] == -1)
                    util += 3;
                if (state[0][i] + state[1][i] + state[2][i] == -1)
                    util += 3;
                if (state[i][0] + state[i][1] + state[i][2] == 0)
                    util += 2;
                if (state[0][i] + state[1][i] + state[2][i] == 0)
                    util += 2;
                if (state[i][0] + state[i][1] + state[i][2] == 1)
                    util += 1;
                if (state[0][i] + state[1][i] + state[2][i] == 1)
                    util += 1;
                if (state[i][0] + state[i][1] + state[i][2] == 2)
                    util += 0;
                if (state[0][i] + state[1][i] + state[2][i] == 2)
                    util += 0;


            }
            if (state[0][0] + state[1][1] + state[2][2] == -2)
                util += 4;
            if (state[0][2] + state[1][1] + state[2][0] == -2)
                util += 4;
            if (state[0][0] + state[1][1] + state[2][2] == -1)
                util += 3;
            if (state[0][2] + state[1][1] + state[2][0] == -1)
                util += 3;
            if (state[0][0] + state[1][1] + state[2][2] == 0)
                util += 2;
            if (state[0][2] + state[1][1] + state[2][0] == 0)
                util += 2;
            if (state[0][0] + state[1][1] + state[2][2] == 1)
                util += 1;
            if (state[0][2] + state[1][1] + state[2][0] == 1)
                util += 1;
            if (state[0][0] + state[1][1] + state[2][2] == 2)
                util += 0;
            if (state[0][2] + state[1][1] + state[2][0] == 2)
                util += 0;
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (state[i][0] + state[i][1] + state[i][2] == 2)
                    util += 4;
                if (state[0][i] + state[1][i] + state[2][i] == 2)
                    util += 4;
                if (state[i][0] + state[i][1] + state[i][2] == 1)
                    util += 3;
                if (state[0][i] + state[1][i] + state[2][i] == 1)
                    util += 3;
                if (state[i][0] + state[i][1] + state[i][2] == 0)
                    util += 2;
                if (state[0][i] + state[1][i] + state[2][i] == 0)
                    util += 2;
                if (state[i][0] + state[i][1] + state[i][2] == -1)
                    util += 1;
                if (state[0][i] + state[1][i] + state[2][i] == -1)
                    util += 1;
                if (state[i][0] + state[i][1] + state[i][2] == -2)
                    util += 0;
                if (state[0][i] + state[1][i] + state[2][i] == -2)
                    util += 0;


            }
            if (state[0][0] + state[1][1] + state[2][2] == 2)
                util += 4;
            if (state[0][2] + state[1][1] + state[2][0] == 2)
                util += 4;
            if (state[0][0] + state[1][1] + state[2][2] == 1)
                util += 3;
            if (state[0][2] + state[1][1] + state[2][0] == 1)
                util += 3;
            if (state[0][0] + state[1][1] + state[2][2] == 0)
                util += 2;
            if (state[0][2] + state[1][1] + state[2][0] == 0)
                util += 2;
            if (state[0][0] + state[1][1] + state[2][2] == -1)
                util += 1;
            if (state[0][2] + state[1][1] + state[2][0] == -1)
                util += 1;
            if (state[0][0] + state[1][1] + state[2][2] == -2)
                util += 0;
            if (state[0][2] + state[1][1] + state[2][0] == -2)
                util += 0;
        }


        return util;
    }



    public boolean isFull(Integer[][] state){
        boolean bool = true;
        for (int i =0; i < 3; i++){
            for (int j = 0 ; j < 3 ; j++) {
                if (state[i][j]==0)
                    bool = false;
            }
        }
        return bool;
    }

    public boolean isWon(Integer [][] state){
        boolean bool = false;
        for (int i=0; i<3;i++){
            if((state[i][0]!=0 && state[i][0]==state[i][1] && state[i][1]==state[i][2])||(state[0][i]!=0 && state[0][i]==state[1][i] && state[1][i]==state[2][i])){
                bool=true;
            }
        }
        if (( state[0][0]!=0 && state[0][0]==state[1][1] && state[1][1]==state[2][2])||(state[0][2]!=0 && state[0][2]==state[1][1] && state[1][1]==state[2][0])){
            bool=true;
        }
        return bool;
    }


}
