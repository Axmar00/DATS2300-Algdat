package ukeoppgaver;

public class Ukeoppgave2 {

    public static void kopier(int[] a, int i, int[] b, int j, int length){

        for(int n = i; n < length; n++){
            b[j] = a[n];
            if(j == length){
                j--;
            }else{
                j++;
            }

        }
        for(int l = 0; l < b.length; l++){
            System.out.print(b[l] + " ");
        }

    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6};
        int[] b = new int[6];
        kopier(a,0,b,b.length,b.length);
        /*-------1.2.1-------*/
        /*Deloppgave1
        public static int min1(int[] a, int fra, int til) {

        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til minste verdi i a[fra:til>
        int minsteverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minsteverdi) {
                m = i;                // indeks til minste verdi oppdateres
                minsteverdi = a[m];     // minste verdi oppdateres
            }
        }
        return m;
    }
         */
        /*Deloppgave 2 - 7
        Gjort i Tabell.java
         */

        /*-------1.2.6-------*/
        /*Deloppgave2
        Metoden vil bruke færrest mulige sammenligninger i tabeller som er
        korte og tabeller som har maksverdien og nest-maksverdien i en av de første posisjonene.
         */
        /*Deloppgave3

         */

        /*-------1.2.8-------*/
        /*Deloppgave1
        Trengs 15 for 16 deltakere. 7 for 8. 2^k - 1 for 2^k.
         */

        /*Deloppgave2
        a)
        3, 15, 8, 11, 13, 9, 10, 5
        15 11 13 10
        15 13
        15
        b)
        10, 17, 13, 16, 17, 8, 12, 15, 9, 15, 16, 15, 10, 13, 14, 17
        17 16 17 15 15 16 13 17
        17 17 16 17
        17 17
        17
         */
        /*Deloppgave3
        9, 21, 5, 25, 27, 23, 26, 28, 17, 15, 19, 18, 16, 20, 14, 10
        9 5 23 26 15 18 16 10
        5 23 15 10
        5 10
        5
        */
        /*-------1.2.9-------*/
        /*Deloppgave1
        Det er 16 bladnoder og 15 indre noder.
         */
        /*Deloppgave2
        Noder = 2^k;
         */

        /*Deloppgave3
        Vi finner de totale antall nodene med en for-løkke med 2^k for alle noder.
        Høyden er k.

         */
        /*-------1.2.9-------*/
        /*Deloppgave1
        a)
        10, 17, 13, 16, 17, 8, 12, 15, 9, 15
        17 16 17 15 15
        17 17 15
        17 15
        17
        17 er største, 15 er nest størst. Vinneren slår ut: 10, 16, 17, 15

        b)
        5, 11, 7, 13, 2, 9, 10, 8, 3, 14, 6, 12
        11 13 9 10 14 12
        13 10 14
        13 14
        14
        14 er størst, og 13 er neststørst. Vinneren slår ut: 3, 12, 13

        c)
        5, 11, 7, 13, 2, 9, 10, 8, 3, 14, 6, 12, 9, 13, 4, 7, 13, 1, 14
        11 13 9 10 14 12 13 7 13 14
        13 10 14 13 14
        13 14 14
        14 14
        14.
        14 = størst, 13 = neststørst. Vinneren slår ut: 3, 12, 13, 14
         */

        /*-------1.2.11-------*/
        /*Deloppgave1
        A)
        Ikke komplett. Ikke perfekt. Er fullt. Høyde = 3. 6 bladonder. Turneringstre.
        B)
        Ikke komplett, ikke perfekt. Er fullt. Høyde = 3. 6 bladnoder. Turneringstre.
        C)
        Komplett, ikke perfekt, ikke fullt. Høyde = 3. 7 bladnoder. Ikke turneringstre.
        D)
        Ikke komplett, ikke perfekt, ikke fullt. Høyde = 3. 4 bladnoder. Ikke turneringstre.
        E)
        Komplett, ikke perfekt, fullt. Høyde = 3. 7 bladnoder. Turneringstre.
        F)
        Ikke komplett, ikke perfekt, ikke fullt. Høyde = 3. 4 bladnoder. Ikke turneringstre.
         */

        /*Deloppgave2
        Sjekk Perfect.png, Complete.png og Complete2.png
         */

        /*Deloppgave3
        Full.png
        Finnes 2 forskjellige fulle binærtrær med 5 noder.
        Finnes 5 forskjellige fulle binærtrær med 7 noder.
         */

        /*-------1.2.13-------*/
        /*Deloppgave1
        public static int[] nestMaks(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        for(int i = b.length-1; i > 0; --i){   // Skriver ut resultatet av turneringen
            System.out.print(b[i] + " ");
        }

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    }
         */

        /*Deloppgave3

         */



    }
}
