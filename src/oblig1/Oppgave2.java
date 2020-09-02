package oblig1;

public class Oppgave2 {
    public static int antallUlikeSortert(int[] a){
        if(a.length==0){
            return 0;
        }
        int ulikeTall = 1;
        for(int i = 1; i < a.length; ++i){
            if(a[i-1] > a[i]){
                throw new IllegalStateException("Arrayet er ikke sortert");
            }
            if(a[i-1] != a[i]){
                ulikeTall++;
            }
        }
        return ulikeTall;
    }
}