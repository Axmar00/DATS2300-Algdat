package ukeoppgaver;
import java.util.*;

public class Ukeoppgave1 {

    public static int maks1(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    }

    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    }

    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    }

    public static int[] randPerm(int n)  // en versjon som ikke virker
    {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n) + 1;    // tabellen fylles med tall

        return a;                     // tabellen returneres
    }

    public static int kostnader(int[] a)  // legges i class Program
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}  // en tom blokk
        return m;
    }


    public static void main(String[] args) {


        System.out.println("Hei AlgDat");
        /*-------1.1.2-------*/

        /*Deloppgave1
        Fant ut at han var en persisk matematiker, astronom, astrolog og geograf. Han levde mellom
        år ca. 790 til ca. år 840.
         */

        /*Deloppgave2
        En algoritme er en ordnet samling av effektive operasjoner
        som gir et resultat etter en viss tid.
         */

        /*Deloppgave3
        Får 1 450 000 000 treff av "data structure" og 245 000 000 treff av "algorithm".
         */




        /*-------1.1.3-------*/
        /*Deloppgave1
        6
         */

        /*Deloppgave2
        public static int min(int[] a)  // a er en heltallstabell
  {
    if (a.length < 1)
      throw new java.util.NoSuchElementException("Tabellen a er tom!");

    int m = 0;  // indeks til foreløpig minste verdi

    for (int i = 1; i < a.length; i++) //
    {
      if (a[i] < a[m]) m = i;  // indeksen oppdateres
    }

    return m;  // returnerer indeksen/posisjonen til den minste verdi

  } // min
  */
        /*Deloppgave3
        public static int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] >= a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    }
      */

        /*-------1.1.3-------*/
        /*Deloppgave5

         public static int[] minmaks(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }

        int m1 = 0; //indeks til startminverdi
        int m2 = 0; //indeks til startmaxverdi


        for(int i = 1; i < a.length; i++) {
            if(a[i] < a[m1]) {
                m1 = i;
            }
            if(a[i] > a[m2]) {
                m2 = i;
            }
        }
        int[] result = {m1,m2};
        return result;
    }
        int[] t = {3,1};
        System.out.println("{"+minmaks(t)[0] + " " + minmaks(t)[1]+"}");

        Bruker 4 sammenligninger.
       */

        /*Deloppgave 6

        public static long fak(int n) {
        if(n < 1) {
            throw new IllegalArgumentException("Godtar kun tall lik en og over");
        }
        int fakSum = n;
        for(int i = n-1; i>1; i--) {
            fakSum*=i;
        }
        return fakSum;
    }
         */

        /*-------1.1.4-------*/
        /*Deloppgave 1

          public static int maks(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // 1
        int maksverdi = a[0];    // 2

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi) // 1 + 10 + 9 + 2*9
        {
            maksverdi = a[i];     // 2*9
            m = i;                // 9
        }
        return m;

    }

       i) {10, 5, 7, 2, 9, 1, 3, 8, 4, 6}
         41 operasjoner.


       ii) {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
         68 operasjoner.
         */

        /*-------1.1.5-------*/
        /*Deloppgave 1
        int[] list = {9,2,4,10,7};
        int[] list2 = {2};
        int[] list3 = {};

        System.out.println(maks(list));
        System.out.println(maks(list2));
        System.out.println(maks(list3));

        Koden gir riktige resultater til alle tabeller, utenom tomme tabeller. Hvis tabellen
        er tom, får vi indexOutOfBoundException.
         */

        /*-------1.1.10-------*/
        /*Deloppgave 1

        // main-metoden i class Program skal nå inneholde:
        int n = 100_000, antall = 2_000; // tabellstørrelse og gjentagelser
        long tid = 0;                    // for tidsmåling
        int a[] = randPerm(n);           // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks1(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");

         */

    }
}
