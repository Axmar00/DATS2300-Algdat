package oblig1;
import java.util.Arrays;

import static hjelpeklasser.Tabell.*;

public class Oppgave4 {

    public static void delsortering(int[] a){

        int antOddetall = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){
                bytt(a,i,antOddetall);
                antOddetall++;
            }
        }
    }

}
