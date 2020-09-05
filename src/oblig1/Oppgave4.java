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
    public static void main(String[] args){
        int[] a = {3,2,1,4,5,6};
        delsortering(a);
        System.out.println(Arrays.toString(a));
    }

}
