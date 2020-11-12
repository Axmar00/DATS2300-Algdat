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
            if(a[i] != null) {
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

    public static <T> void snu2(Stakk<T> A){
        Stakk<T> B = new TabellStakk<>();               //Hjelpestakk B
        int n = A.antall() - 1;

        for(int i = n; i > 0; i--){
            T v = A.taUt();
            for (int j = 0; j < n; j++) B.leggInn(A.taUt());
            A.leggInn(v);
            while(!B.tom()) A.leggInn(B.taUt());
            n--;
        }
    }

    public static <T> void kopier(Stakk<T> A, Stakk<T> B){
        Stakk<T> C = new TabellStakk<T>();

        while(!A.tom()) C.leggInn(A.taUt());
        while(!C.tom()){
           T v = C.taUt();
            A.leggInn(v);
            B.leggInn(v);
        }
    }

    public static <T> void kopier2(Stakk<T> A, Stakk<T> B){
        int n = A.antall();

        while(n > 0){
            for(int i = 1; i < n; i++)B.leggInn(A.taUt());
            T v = A.kikk();
            for(int i = 1; i < n; i++){
                A.leggInn(B.taUt());
            }
            B.leggInn(v);
            n--;
        }
    }

    public static <T> void sorter(Stakk<T> A, Comparator<? super T> c){
       Stakk<T> B = new TabellStakk<T>();
        int n = A.antall();

        for(int i = 0; i < A.antall(); i++){
            T v = A.taUt();
            for(int j = 1; j < n; j++) {
                if (c.compare(v, A.kikk()) <= 0) {
                    B.leggInn(v);
                    v = A.taUt();
                } else {
                    B.leggInn(A.taUt());
                }
            }
            A.leggInn(v);
            while(!B.tom()) A.leggInn(B.taUt());
            n--;
        }
        //Fra fasiten
        /*Stakk<T> B = new TabellStakk<T>();
        T temp; int n = 0;

        while (!A.tom())
        {
            temp = A.taUt();
            n = 0;
            while (!B.tom() && c.compare(temp,B.kikk()) < 0)
            {
                n++; A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            for (int i = 0; i < n; i++) B.leggInn(A.taUt());
        }

        while (!B.tom()) A.leggInn(B.taUt());*/
    }

    public static <T> void omvendtkopi(Stakk<T> a, Stakk<T> b){
        Stakk<T> c = new TabellStakk<>();
        while(!a.tom()){
            T temp = a.taUt();
            c.leggInn(temp);
            b.leggInn(temp);
        }
        while(!c.tom()) a.leggInn(c.taUt());
    }

    public static <T> int indeks(Stakk<T> s, T verdi){
        Stakk<T> t = new TabellStakk<>();
        int indeks = 0;
        while(!s.tom()){
            T temp = s.taUt();
            if(temp.equals(verdi)){
                s.leggInn(temp);
                break;
            }
            t.leggInn(temp);
            indeks++;
        }
        while(!t.tom()) s.leggInn(t.taUt());
        return indeks==s.antall() ? -1 : indeks;
    }

    public static void main(String[] args) {


    }

}  // class TabellStakk
