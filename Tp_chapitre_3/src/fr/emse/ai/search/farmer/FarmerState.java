package fr.emse.ai.search.farmer;

public class FarmerState {

    public final static String AAAA = "AAAA";
    public final static String BABA = "BABA";
    public final static String AABA = "AABA";
    public final static String BABB = "BABB";
    public final static String AAAB = "AAAB";
    public final static String BBBA = "BBBA";
    public final static String ABAA = "ABAA";
    public final static String BBAB = "BBAB";
    public final static String ABAB = "ABAB";
    public final static String BBBB = "BBBB";

    public String value;

    FarmerState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        return o instanceof FarmerState && ((FarmerState) o).value.equals(this.value);
    }

    public String toString() {
        return value;
    }

}
