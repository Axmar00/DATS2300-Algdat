package oblig1;
import java.util.Arrays;

import static hjelpeklasser.Tabell.*;

public class Oppgave4 {

    public static void partisjonering(int a[], int v, int h)
    {
        if(h-v <= 0)
            return;

        int pivot = h;    //skilleverdi
        int placement = v;
        for(int i = v; i < h; i++){
            if(a[i] < a[pivot]){

                int temp = a[placement];
                a[placement] = a[i];
                a[i] = temp;

                placement++;
            }
        }

        int temp = a[pivot];
        a[pivot] = a[placement];
        a[placement] = temp;


        partisjonering(a, v, placement-1);
        partisjonering(a, placement+1, h);
    }


    public static void delsortering(int[] a){
        int oddetall = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){
                bytt(a,i,oddetall);
                oddetall++;
            }
        }
        partisjonering(a,0,oddetall-1);
        partisjonering(a,oddetall,a.length-1);
    }


    public static void main(String[] args){
        int[] a ={1,3,5,6,2,3,7};
        partisjonering(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }

}
