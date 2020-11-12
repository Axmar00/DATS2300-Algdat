package oblig1;

import static oblig1.Oblig1Test.bytt;

public class Oppgave2 {
    public static int antallUlikeSortert(int[] a){
        if(a.length==0){ //Hvis tabellen er tom, return 0.
            return 0;
        }
        int ulikeTall = 1;
        for(int i = 1; i < a.length; ++i){
            if(a[i-1] > a[i]){
                throw new IllegalStateException("Arrayet er ikke sortert");
            }
            if(a[i-1] != a[i]){
                ulikeTall++;
            }
        }
        return ulikeTall;
    }

    //EksamensoppgaveH15
    public static int fjernDuplikater(int[] a)
    {
        if(a.length == 0) return 0; // ingen forskjellige verdier

        int j = 1;
        for (int i = 1; i < a.length; i++)
        {
            // hvis a[i - 1] == a[i], tas ikke a[i] med
            if (a[i - 1] != a[i]) a[j++] = a[i];
        }
        // nuller resten av tabellen
        for (int i = j; i < a.length; i++) a[i] = 0;

        return j;  // antall forskjellige verdier
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,3,4,5};
    }

}