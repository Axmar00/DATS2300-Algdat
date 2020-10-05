package hjelpeklasser;

import java.util.*;

public class TabellStakk<T> implements Stakk<T>
{
    private T[] a;                     // en T-tabell
    private int antall;                // antall verdier på stakken

    public TabellStakk()               // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde)     // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[])new Object[lengde];     // oppretter tabellen
        antall = 0;                      // stakken er tom
    }

    @Override
    public void leggInn(T verdi) {
        if (antall == a.length)
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2*antall);   // dobler

        a[antall++] = verdi;
    }

    @Override
    public T kikk() {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall-1];    // returnerer den øverste verdien
    }

    @Override
    public T taUt() {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--;             // reduserer antallet

        T temp = a[antall];   // tar var på det øverste objektet
        a[antall] = null;     // tilrettelegger for resirkulering

        return temp;          // returnerer den øverste verdien
    }

    @Override
    public int antall() {return antall;  }

    @Override
    public boolean tom() { return antall == 0;  }

    @Override
    public void nullstill() {
        /*while(antall != 0){
            a[antall-1] = null;
            antall--;
        }*/
        for(int i = 0; i < antall; i++) a[i] = null;
        antall = 0;
    }

    @Override
    public String toString(){
        if(tom()) return "[]";
        StringBuilder s = new StringBuilder();
        s.append("[").append(a[antall-1]);
        for(int i = antall-2; i >= 0; i--) {
            if(!a[i].equals(null)) {
                s.append(",").append(" ").append(a[i]);
            }
        }
        s.append("]");
        return s.toString();
    }

    public static <T> void snu(Stakk<T> A){
        Stakk<T> B = new TabellStakk<>();               //Hjelpestakk B
        Stakk<T> C = new TabellStakk<>();               //Hjelpestakk C

        while(!A.tom()) B.leggInn(A.taUt());
        while(!B.tom()) C.leggInn(B.taUt());
        while(!C.tom()) A.leggInn(C.taUt());
    }

    public static <T> void kopier(Stakk<T> A, Stakk<T> B){
        Stakk<T> C = new TabellStakk<>();
        T v;
        for()
    }

}  // class TabellStakk
