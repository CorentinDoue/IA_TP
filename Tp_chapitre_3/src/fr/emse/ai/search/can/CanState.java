package fr.emse.ai.search.can;

public class CanState {

    public final static int[] A = {12,3};
    public final static int[] B = {0,3};
    public final static int[] C = {3,0};
    public final static int[] D = {12,0};
    public final static int[] E = {7,5};
    public final static int[] F = {7,0};
    public final static int[] G = {2,5};
    public final static int[] H = {2,0};
    public final static int[] I = {0,2};
    public final static int[] J = {0,0};
    public final static int[] K = {0,5};
    public final static int[] L = {5,0};
    public final static int[] M = {15,0};
    public final static int[] N = {10,5};
    public final static int[] O = {10,0};
    public final static int[] P = {5,5};

    public int[] value;

    CanState(int[] value) {
        this.value = value;
    }


    public boolean equals (int[] value2) {
        return value2 instanceof int[] && value2[0] == this.value[0] && value2[1] == this.value[1];
    }

    public String toString() {
        return "["+String.valueOf(value[0])+","+String.valueOf(value[1])+"]";
    }

}
