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
    
    public static void main(String[] args) {

    }
}
