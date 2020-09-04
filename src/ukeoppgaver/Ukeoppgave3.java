package ukeoppgaver;
import java.util.Arrays;

import static hjelpeklasser.Tabell.*;


public class Ukeoppgave3 {

    /*-------1.3.1-------*/
    /*Deloppgave2
    a) 2 3 6 1 4 5, neste: 2 3 6 1 5 4
    b) 2 3 6 1 5 4, neste: 2 3 6 5 1 4
    c) 2 3 1 6 5 4, neste: 2 3 6 1 4 5
    d) 2 3 6 5 4 1, neste: 2 6 1 3 4 5
    e) 2 6 5 4 3 1, neste: 6 1 2 3 4 5
     */

    /*Deloppgave3
    3 1 4 9 8 2 5 6 7 10
    3 1 4 9 8 2 5 6 10 7
    3 1 4 9 8 2 5 7 6 10
    3 1 4 9 8 2 5 7 10 6
    3 1 4 9 8 2 5 10 6 7
    3 1 4 9 8 2 5 10 7 6
    3 1 4 9 8 2 6 5 7 10
    3 1 4 9 8 2 6 5 10 7
    3 1 4 9 8 2 6 7 5 10
    3 1 4 9 8 2 6 7 10 5
     */

    /*-------1.3.2-------*/
    /*Deloppgave1
    Hvor mange invensjoner i :3 5 4 7 6 8 1 2 9 10?
    14.
     */

    /*-------1.3.4-------*/
    /*Deloppgave1
    i) 3 4 5 6 7 16 21 19 23 10 14 15 11 17 8
    ii) 3 4 5 6 7 8 10 16 21 19 23 14 15 11 17
     */

    /*Deloppgave9
    public static void utvalgssortering(int[] a, int fra, int til){
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) {
            bytt(a, i, min(a, i, til));
        }
    }
     */

    /*Deloppgave10
    Den er ikke stabil fordi like verdier kan endre rekkefølgen de hadde.
     */

    /*Deloppgave11

     */

    /*-------1.3.5-------*/
    /*Deloppgave2
    Den returnerer -1 hvis verdien er mindre enn den minste.
    Returnerer -1 hvis a.length = 0.
    lineærsøk(a,2); -1
    lineærsøk(a,15); -6
    lineærsøk(a,16); 5
    lineærsøk(a,40); 14
    lineærsøk(a,41); -16
     */

    /*Deloppgave3
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = a.length-1; for( ; a[i] > verdi; i--);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }
     */

    /*Deloppgave 5

     */

    /*-------1.3.6-------*/
    /*Deloppgave3
    i) Den siste verdien.
    ii) Den siste verdien.
    iii) Den siste verdien.
    iv) Den første verdien.
     */
    /*Deloppgave4
    Testet. Det stemte.
     */

    /*-------1.3.8-------*/
    /*Deloppgave3

     */


}
