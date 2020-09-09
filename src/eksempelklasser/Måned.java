package eksempelklasser;

import java.util.*;

public enum Måned {
    JAN (1,"januar"),
    FEB (2,"februar"),
    MAR (3,"mars"),
    APR (4,"Mars"),
    MAI (5,"mai"),
    JUN (6,"juni"),
    JUL (7,"juli"),
    AUG (8,"august"),
    SEP (9,"september"),
    OKT (10,"oktober"),
    NOV (11,"november"),
    DES (12,"desember");

    private final int mndnr;
    private final String fulltnavn;

    private Måned(int mndnr, String fulltnavn){
        this.mndnr = mndnr;
        this.fulltnavn = fulltnavn;
    }
    public int mndnr(){return mndnr;};

    @Override
    public String toString(){ return fulltnavn;};

    public static String toString(int mnd){
        if(mnd < 1 || mnd > 12){
            throw new IllegalArgumentException("Ulovlig månednummer");
        }
        return values()[mnd - 1].toString();
    }
    public static Måned[] vår(){
        return Arrays.copyOfRange(values(),3,5);
    }
    public static Måned[] sommer(){
        return Arrays.copyOfRange(values(),5,8);
    }
    public static Måned[] høst(){
        return Arrays.copyOfRange(values(),8,10);
    }
    public static Måned[] vinter(){
        //return Arrays.copyOfRange(values(),11,3);
        return new Måned[] {NOV, DES, JAN, FEB, MAR};
    }

    public static void main(String[] args) {
        for (Måned m : Måned.vinter())
        {
            System.out.println(m.toString() + " (" + m.name() + ") " + m.mndnr );
        }
    }
}
