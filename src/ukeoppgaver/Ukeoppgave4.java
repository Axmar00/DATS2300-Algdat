package ukeoppgaver;

import hjelpeklasser.Tabell;

import java.util.Arrays;

public class Ukeoppgave4 {
    /*-------1.4.1-------*/
    /*Deloppgave2
    public static int maks(char[] c)
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = c[0];             // største verdi

        for (int i = 1; i < c.length; i++) if (c[i] > maksverdi)
        {
            maksverdi = c[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }
     */

    /*Deloppgave3
    public static int maks(Integer[] a)
    {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }
     */

    /*Deloppgave4
    a.compareTo(b):
    Hvis a = b, returnerer 0.
    a > b, returnerer 1.
    a < b, returnerer -1.
     */

    /*Deloppgave5
    a og b er Strings
    a.compareTo(b):
    a = b, returnerer 0
    A og B, returnerer -1
    Æ og Å, returnerer 1
    Karianne og Kari vil returnere forskjellen mellom lengden-. 8-4: 4.

    Den returnerer forskjellen mellom posisjonene til ascii-verdiene
     */

    /*Deloppgave6
    System.out.println(Boolean.compare(false, true));
    Returnerer -1.
     */

    /*------1.4.3------*/
    /*Deloppgave2
    Integer.compare(-1,1) returner -1
    Integer.compareUnsigned(-1,1) returnerer 1
     */

    /*Deloppgave7
    double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11}
        Double[] d2 = new Double[d.length];
        //hvert element fra int tabellen legges inn i Integer-tabellen
        for(int i = 0; i < d2.length; i++) d2[i] = d[i]; //autoboksing
        Tabell.innsettingssortering(d2);
        Tabell.skrivln(d2);
     */

    /*Deloppgave8
    Gitt disse to metodene:
    public static void f(int a, Integer b) { }
    public static void f(Integer a, int b) { }
    Det er tvetydig. For å kunne bruke noen av metodene må
    int-verdien konverteres til en Integer. Det ene er ikke riktigere enn det andre.
    Dersom en metode fjernes, vil den andre kunne kjøres uten problem.
    Vi kan bestemme hvilken metode vi bruker ved å velge hvilket tall vi konverterer til Integer.
     */

    /*-------1.4.6-------*/
    /*Deloppgave1
     Person[] p = new Person[5];                       // en persontabell
            p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
            p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
            p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
            p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
            p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

            class FornavnKomparator implements Komparator<Person>
            {
                public int compare(Person p1, Person p2)        // to personer
                {
                    return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
                }
            }
    //Komparator<Person> c = new FornavnKomparator();

    //Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
    //Tabell.innsettingssortering(p, c);
            Tabell.innsettingssortering(p,(p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));

            System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
     */

    /*Deloppgave3
    Tabell.innsettingssortering(s,(s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    if(k!=0) return k;
                      k = s1.fornavn().compareTo(s2.fornavn());
                    if(k!=0) return k;
                    return s1.etternavn().compareTo(s2.etternavn());
                }

                );
     */

    /*Deloppgave5
    String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(s, (x,y) ->
        {
            int k = x.length() - y.length();
            return k!=0 ? k : x.compareTo(y);
        }
        );

        System.out.println(Arrays.toString(s));
     */

    /*Deloppgave7

    Komparator<Student> c = (s1,s2) ->
        {
            int cmp = s1.studium().name().compareTo(s2.studium().name());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };
     */

}
