package ukeoppgaver;

import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Ukeoppgave11 {
    /*-------6.1.3-------*/
    /*Delopg1
    String a = "a", b = "b", c = "c", d = "d";
        System.out.println(a.hashCode() + " " + b.hashCode());
        System.out.println(c.hashCode() + " " + d.hashCode());
     */

    /*Delopg2
    int n = 197;
        int [] arr = new int[n];
        for(int i = 0; i < 400; i++){
            String s = "A";
            if (i < 100) s += 0;
            if (i < 10) s += 0;
            s += i;
            arr[s.hashCode() % n]++;

        }
        int m = Tabell.maks(arr);  // posisjonen til største verdi
        int maks = arr[m];         // den største verdien

        int[] frekvens = new int[maks + 1];
        for (int i = 0; i < arr.length; i++) frekvens[arr[i]]++;  // teller opp
     */

    /*Delopg5
    if (k < 0) k = ~k;
     */

    /*Delopg7
    int h = hash("ABC", 10, 3.14);
        System.out.println(h);
     */

    public static int hash(String s)
    {
        int h = 0;
        for (int i = 0; i < s.length(); i++)
        {
            h = (h << 5) ^ s.charAt(i) ^ h;
        }
        return h;
    }

    public static int hash2(String s)
    {
        int h = 0;
        for (int i = 0; i < s.length(); i++)
        {
            h = (h << 4) + s.charAt(i);
            int g = h & 0xf0000000;
            if (g != 0) h ^= (g >>> 24);
            h &= ~g;
        }
        return h;
    }

    public static int hash(Object... verdier)
    {
        if (verdier == null) return 0;
        int h = 1;
        for (Object o : verdier)
        {
            h = h*31 + (o == null ? 0 : o.hashCode());
        }
        return h;
    }

    public static void main(String[] args) {

    }
}
