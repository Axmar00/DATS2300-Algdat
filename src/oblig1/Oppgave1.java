package oblig1;

public class Oppgave1 {
    public static int maks(int[] a){

        for(int i = 0; i < a.length-1; ++i){
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        int pMax = a[a.length-1];
        return pMax;
    }
    public static void main(String[] args){
        int[] a = {3,4,2,1,3};
        System.out.print(maks(a));
    }
}
