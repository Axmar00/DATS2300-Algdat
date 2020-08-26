package ukeoppgaver;
import hjelpeklasser.*;

public class Program
{
    public static void main(String[] args)      // hovedprogram
    {
        /*int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);*/

        /*int b[] = {1,2,3};
        int c[] = null;
        System.out.println(Tabell.maks(b,0,1));*/

       int[] x = Tabell.naturligeTall( 7);
       int[] y = Tabell.heleTall(0,5);
       Tabell.fratilKontroll(x.length,0,7);
       Tabell.fratilKontroll(y.length,2,4);



    }

}