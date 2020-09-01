package oblig1;

import java.util.NoSuchElementException;

public class Oppgave1 {
    public static int maks(int[] a){
        if(a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt.");
        }

        for(int i = 0; i < a.length-1; ++i){
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        int pMax = a[a.length-1];
        return pMax;
    }
}
