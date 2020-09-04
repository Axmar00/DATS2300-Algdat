package oblig1;

import java.util.Arrays;

public class Oppgave5 {
    public static void rotasjon(char[] a){
        if(a.length > 1) {
            char siste = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = siste;
        }
    }
}
