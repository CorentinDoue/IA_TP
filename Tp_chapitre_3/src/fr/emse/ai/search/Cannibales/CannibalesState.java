package fr.emse.ai.search.Cannibales;


//L'état est une chaîne de caractère de type 'l1'+'r'
// avec l1 une sous chaîne contenant M pour un missionnaire et C pour un cannibale sur la rive gauche
// (il n'est pas nécessaire d'expliciter les individus présents sur la rive droite )
// avec r=G si le bateau est sur la rive gauche et r=D si le bateau est sur la rive droite

public class CannibalesState {
    public final static String MMMD ="MMMD";
    public final static String MMMCG ="MMMCG";
    public final static String MCD ="MCD";
    public final static String MMCCG ="MMCCG";
    public final static String CCD ="CCD";
    public final static String CCCG ="CCCG";
    public final static String MMMCCG ="MMMCCG";
    public final static String MMCCD ="MMCCD";
    public final static String MMMCD ="MMMCD";
    public final static String MMMCCCG ="MMMCCCG";
    public final static String MMMCCD ="MMMCCD";

    public String value;

    CannibalesState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        return o instanceof CannibalesState && ((CannibalesState) o).value.equals(this.value);
    }

    public String toString() {
        return value;
    }
}
