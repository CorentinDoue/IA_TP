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
        if (count==49){
            return 2;
        }else{
            return count % 2;
        }

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
        boolean ligne_vide =false;
        for (int i = 0; i < 7; i++) {
            int count =0;
            for (int j = 0; j < state.get(i).size(); j++) {
                if (checkVoisins(state, i, j, 1, -1)==state.get(i).get(j) || checkVoisins(state, i, j, 1, 0)==state.get(i).get(j) || checkVoisins(state, i, j, 1, 1)==state.get(i).get(j))
                    //il y a une ligne ou un diagonale de 4
                    return true;
                if (j>0 && state.get(i).get(j)==state.get(i).get(j-1)){
                    if (count==2){
                        // il y a une colonne de 4
                        return true;
                    }else{
                        count++;
                    }
                }else{
                    count=0;
                }
            }
            if (state.get(i).size()<7){
                ligne_vide=true;
            }
        }
        if (!ligne_vide){
            //la grille est pleine
            return true;
        }
        return false;
    }
// checkVoisins : vérifie que le voisin du pion [i,j] dans la direction dir
// est de la meme nature que lui.
// la grille est balayée de manière récursive à i croissant,
// si il y a 4 pions allignés de meme nature on renvoie la nature du pion
// sinon on renvoie l'inverse de la nature du pion.
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
//    checkVoisin2 :  vérifie le voisin du pion en [i,j]
//    et détermine l'utilité  d'un groupe de 4 pion dans la direction données par dir,
//    balaye la grille récurssivement à i croissant.
//    Les utilités sont définies comme suit :
//    3 => Il y a un trou et il peut etre comblé au prochain tour
//    2 => Il y a un trou et il peut etre comblé mais il faudra plusieur tour
//    1 => Il y a plus d'un trou
//    0 => Non valorisable (Hors plateau ou comblé par l'adverssaire)
    private double checkVoisins2(ArrayList<ArrayList<Boolean>> state, int i, int j, int deep, int dir, double utility, boolean cherched){
        if (i<6){
            if (j+dir >= 0){
                if (j+dir < state.get(i+1).size()){
                    if (cherched == state.get(i + 1).get(j + dir)) {
                        if (deep == 3)
                            return utility;
                        else
                            return checkVoisins2(state, i + 1, j + dir, deep + 1, dir, utility,cherched);
                    } else {
                        return 0;
                    }
                }else{
                    if (j+dir-1 < state.get(i+1).size()){
                        if (utility==3 || utility==2 || utility==1){
                            if (deep == 3)
                                return 1;
                            else
                                return checkVoisins2(state, i + 1, j + dir, deep + 1, dir, 1,cherched);
                        }else{
                            if (deep == 3)
                                return 3;
                            else
                                return checkVoisins2(state, i + 1, j + dir, deep + 1, dir, 3,cherched);
                        }

                    }else{
                        if (utility==3 || utility==2 || utility==1){
                            if (deep == 3)
                                return 1;
                            else
                                return checkVoisins2(state, i + 1, j + dir, deep + 1, dir, 1,cherched);
                        }else{
                            if (deep == 3)
                                return 2;
                            else
                                return checkVoisins2(state, i + 1, j + dir, deep + 1, dir, 2,cherched);
                        }
                    }
                }
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

// checkVoisin3 : pareil que checkvoisin2 mais balaye la grille à i décroissant
// (cela permet de détecter les groupes qui commençaient par un trou à i croissant)
    private double checkVoisins3(ArrayList<ArrayList<Boolean>> state, int i, int j, int deep, int dir, double utility, boolean cherched){
        if (i>0){
            if (j+dir >= 0){
                if (j+dir < state.get(i-1).size()){
                    if (cherched == state.get(i - 1).get(j + dir)) {
                        if (deep == 3)
                            return utility;
                        else
                            return checkVoisins3(state, i - 1, j + dir, deep + 1, dir, utility,cherched);
                    } else {
                        return 0;
                    }
                }else{
                    if (j+dir-1 < state.get(i-1).size()){
                        if (utility==3 || utility==2 || utility==1){
                            if (deep == 3)
                                return 1;
                            else
                                return checkVoisins3(state, i - 1, j + dir, deep + 1, dir, 1,cherched);
                        }else{
                            if (deep == 3)
                                return 3;
                            else
                                return checkVoisins3(state, i - 1, j + dir, deep + 1, dir, 3,cherched);
                        }

                    }else{
                        if (utility==3 || utility==2 || utility==1){
                            if (deep == 3)
                                return 1;
                            else
                                return checkVoisins3(state, i - 1, j + dir, deep + 1, dir, 1,cherched);
                        }else{
                            if (deep == 3)
                                return 2;
                            else
                                return checkVoisins3(state, i - 1, j + dir, deep + 1, dir, 2,cherched);
                        }
                    }
                }
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    // Utility : renvoie l'uitlité globale de la grille pour pour un joueur (cherched)
    // pour celà on récupére l'utilité de chaque pion placé et on les sommes.
    private double Utility(ArrayList<ArrayList<Boolean>> state, boolean cherched) {
        double utility = 0;
        double temp;
        for (int i = 0; i < 7; i++) {
            int count =0;
            for (int j = 0; j < state.get(i).size(); j++) {
                if (state.get(i).get(j)==cherched){
                    temp = checkVoisins2(state, i, j, 1, -1,0,state.get(i).get(j));
                    temp = Math.max(temp,checkVoisins3(state, i, j, 1, 1,0,state.get(i).get(j)));
                    utility += temp;

                    temp = checkVoisins2(state, i, j, 1, 1,0,state.get(i).get(j));
                    temp = Math.max(temp,checkVoisins3(state, i, j, 1, -1,0,state.get(i).get(j)));
                    utility += temp;

                    temp = checkVoisins2(state, i, j, 1, 0,0,state.get(i).get(j));
                    temp = Math.max(temp,checkVoisins3(state, i, j, 1, 0,0,state.get(i).get(j)));
                    utility += temp;
                }

                if (j>0 && state.get(i).get(j)==cherched){
                    if (count==2){
                        utility += 3;
                    }else{
                        count++;
                    }
                }else{
                    count=0;
                }
            }
        }
        return utility;
    }

    @Override
    public double getUtility(ArrayList<ArrayList<Boolean>> state, Integer player) {
        if (isTerminal(state)) {
            if (getPlayer(state) == player) {
                return Double.NEGATIVE_INFINITY;
            } else {
                return Double.POSITIVE_INFINITY;
            }
        }else{
            if (getPlayer(state) == player) {
                boolean cherched;
                if (getPlayer(state) == 1) {
                    cherched = true;
                } else {
                    cherched = false;
                }
                return Utility(state, cherched);
            }else{
                boolean cherched;
                if (getPlayer(state) == 1) {
                    cherched = true;
                } else {
                    cherched = false;
                }
                return -Utility(state, cherched);
            }
        }
    }
}
