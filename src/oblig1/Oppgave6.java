package oblig1;

import java.util.Arrays;

public class Oppgave6 {
    public static void rotasjon(char[] a, int k){
        if(k == 0) {
            return;
        }
        else {
            char siste = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = siste;

            rotasjon(a, --k);
        }
    }
    public static void main(String[] args){
        char[] a = {'a','b','c','d'};
        rotasjon(a,3);
        System.out.println(Arrays.toString(a));
    }
}
