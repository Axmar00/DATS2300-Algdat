package oblig1;
import java.util.Arrays;

import static hjelpeklasser.Tabell.*;

public class Oppgave4 {

    public static int partisjonering(int a[], int v, int h)
    {
        int skilleverdi = a[h];
        int i = (v-1);
        for (int j = v; j < h; j++)
        {
            // Hvis tallet er mindre enn skilleverdi
            if (a[j] < skilleverdi)
            {
                i++;

                // bytt a[i] med a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //Sett skilleverdien tilbake
        int temp = a[i+1];
        a[i+1] = a[h];
        a[h] = temp;

        return i+1;
    }

    public static void partisjonering2(int[] a, int v, int h)
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = partisjonering(a, v, h);
        partisjonering2(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        partisjonering2(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void delsortering(int[] a){
        int oddetall = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){
                bytt(a,i,oddetall);
                oddetall++;
            }
        }
        partisjonering2(a,0,oddetall-1);
        partisjonering2(a,oddetall,a.length-1);
    }

    public static void main(String[] args){
        int[] a = {3,2,6,4,5,3,4};
        int n = a.length-1;
        delsortering(a);
        System.out.println(Arrays.toString(a));

    }

}
