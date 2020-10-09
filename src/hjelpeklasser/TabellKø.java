package hjelpeklasser;

import java.util.*;

public class TabellKø<T> implements Kø<T>
{
    private T[] a;      // en tabell
    private int fra;    // posisjonen til den første i køen
    private int til;    // posisjonen til første ledige plass

    @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
    public TabellKø(int lengde)
    {
        if (lengde < 1)
            throw new IllegalArgumentException("Må ha positiv lengde!");

        a = (T[])new Object[lengde];

        fra = til = 0;    // a[fra:til> er tom
    }

    public TabellKø()   // standardkonstruktør
    {
        this(8);
    }

    private T[] utvidTabell(int lengde)
    {
        @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
                T[] b = (T[])new Object[lengde];  // ny tabell

        // kopierer intervallet a[fra:a.length> over i b
        System.arraycopy(a,fra,b,0,a.length - fra);

        // kopierer intervallet a[0:fra> over i b
        System.arraycopy(a,0,b,a.length - fra, fra);

        fra = 0; til = a.length;
        return b;
    }

    @Override
    public boolean leggInn(T verdi) {  // null-verdier skal være tillatt
        a[til] = verdi;                                 // ny verdi bakerst
        til++;                                          // øker til med 1
        if (til == a.length) til = 0;                   // hopper til 0
        if (fra == til) a = utvidTabell(2*a.length);    // sjekker og dobler
        return true;                                    // vellykket innlegging
    }

    @Override
    public T kikk() {
        if(fra == til)    //Sjekker om tabellen er tom
            throw new NoSuchElementException("Tabellen er tom!");

        return a[fra];  //Returnerer den øverste verdien
    }

    @Override
    public T taUt() {
        if (fra == til) throw new         // sjekker om køen er tom
                NoSuchElementException("Køen er tom!");

        T temp = a[fra];                  // tar vare på den første i køen
        a[fra] = null;                    // nuller innholdet
        fra++;                            // øker fra med 1
        if (fra == a.length) fra = 0;     // hopper til 0
        return temp;                      // returnerer den første
    }

    @Override
    public int antall() {
        return fra <= til ? til - fra : a.length + til - fra;
    }

    @Override
    public boolean tom() {
        return fra == til;
    }

    @Override
    public void nullstill() {
        while(fra != til){
            a[fra++] = null;
            if(fra == a.length) fra = 0;
        }
    }

    @Override
    public String toString(){
        if(tom()) return "[]";
        int helpFra = fra;

        StringBuilder s = new StringBuilder();
        s.append("[").append(a[helpFra]);
        helpFra++;
        if(helpFra == a.length) helpFra = 0;

        while(helpFra != til){
            s.append(",").append(" ").append(a[helpFra]);
            helpFra++;
            if(helpFra == a.length) helpFra = 0;
        }
        s.append("]");
        return s.toString();
    }

    public int indeksTil(T verdi){
        int hFra = fra;

        while(hFra != til){
            if(verdi.equals(a[hFra])) {
                return fra <= hFra ? hFra - fra : a.length + hFra - fra;
            }
            hFra++;
            if(hFra == a.length) hFra = 0;
        }
        return -1;      //ikke funnet
    }

    public static <T> void snu(Stakk<T> A) {
        Kø<T> B = new TabellKø<T>();     //Hjelpekø B

        while(!A.tom()) B.leggInn(A.taUt());
        while(!B.tom()) A.leggInn(B.taUt());;
    }

    public static <T> void snu(Kø<T> A){
        Stakk<T> B = new TabellStakk<T>();

        while(!A.tom()) B.leggInn(A.taUt());
        while(!B.tom()) A.leggInn(B.taUt());
    }

    public static void main(String[] args) {
        TabellKø<Integer> k = new TabellKø<>();
        int[] arr = {1,2,3,4,5,6};
        for(int i = 0; i < arr.length; i++) k.leggInn(arr[i]);
        System.out.println(k);
        k.snu(k);
        System.out.println(k);



    }
} // class TabellKø
