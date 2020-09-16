package ukeoppgaver;

import static hjelpeklasser.Tabell.maks;

public class Ukeoppgave5 {
    /*-------1.5.1-------*/
    /*Deloppgave1
    public static int a(int n)           // n et ikke-negativt tall
    {
        if (n < 0) throw new IllegalArgumentException("n er negativ!");

        int x = 0, y = 1, z = 1;

        for (int i = 0; i < n; i++)
        {
            z = 2*y + 3*x; x = y; y = z;
        }
        return z;
    }
     */

    /*Deloppgave3

    public static int tverrsum(int n)              // n må være >= 0
    {
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n = n /10;
        }
        return sum;
    }
     */

    /*Deloppgave4
    public static int tverrsum(int n)              // n må være >= 0
    {
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n = n /10;
        }
        return sum;
    }
     */

    /*Deloppgave7
    public static int kvadratsum(int n) {
        if(n == 1) return 1;

        return n*n + kvadratsum(n - 1);
    }
     */

    /*Deloppgave8
    public static int sum(int k, int n){
        if(k == n) return n;
        int m = (k+n)/2;
        return sum(k,m) + sum(m+1,n);
    }
     */

    /*Deloppgave9

    public static int maksPos(int[] a, int v, int h){

        if(v == h) return v;
        int m = (v + h) / 2;
        int mv = maksPos(a,v,m);
        int mh = maksPos(a,m+1,h);

        return a[mv] >= a[mh] ? mv : mh;
    }
    public static int maksPos(int[] a)
    {
        return maksPos(a,0,a.length-1);
    }

     */

    /*Deloppgave10
    public static int fakultet(int n){ //Ikke tall n <= 0
        return n < 2 ? 1 : fakultet(n-1)*n;
    }
     */

    /*-------1.5.2-------*/
    /*Deloppgave2
    public static int euklid(int a, int b)
    {
        System.out.println("euklid(" + a + "," + b + ") starter!");
        if (b == 0) {
            System.out.println("euklid(" + a + "," + b + ") er ferdig!");
            return a;
        }
        int r = a % b;            // r er resten
        int k =  euklid(b,r);       // rekursivt kall
        System.out.println("euklid(" + a + "," + b + ") er ferdig!");
        return k;
    }
     */

    /*Deloppgave6
    15.
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610
     */

    /*-------1.5.3-------*/
    /*Deloppgave1
    Krav 1 oppfylles fordi tilfelle(n) vil reduseres for hvert kall.
    Krav 2 oppfylles fordi det har et basistilfelle som vil nås uten et till kall på metoden(n == 1).
    Maksimal rekursjonsdybde er n siden det blir n lag på programstakken.
     */

    /*Deloppgave2
    Krav 1 oppfykkes fordi tilfelle m reduseres hele tida, slik at avstanden mellom v og h blir mindre og mindre.
    Krav 2 oppfylles fordi det har et basistilfelle(v == h) som vil nås tilslutt, og det ikke trengs flere kall.
    Hvis metoden kalles med v = 0 og h = a.length-1, vil maksimal rekursjonsdybde bli ⌈log2(n)⌉ + 1 der n = a.length.
     */

    /*-------1.5.7-------*/

    /*Deloppgave1
    private static void kvikksortering0(int[] a, int v, int h)
    {
        System.out.println("Kallet med [" + v + ":" + h + "] starter!");
        if (v >= h) return;   // tomt eller maks ett element

        int k = sParter0(a,v,h,(v + h)/2);   // se Programkode 1.3.9 f)
        if (v < k - 1) kvikksortering0(a, v, k - 1);    // sorterer intervallet a[v : p - 1]
        if (k + 1 < h) kvikksortering0(a, k + 1, h);    // sorterer intervallet a[p + 1 : h]
        System.out.println("Kallet med [" + v + ":" + h + "] er ferdig!");
    }

    public static void kvikksortering(int[] a) // sorterer hele tabellen
    {
        if (a.length > 1) kvikksortering0(a, 0, a.length - 1);
    }
     */

    public static void main(String[] args) {

    }
}
