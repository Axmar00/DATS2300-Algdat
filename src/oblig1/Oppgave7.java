package oblig1;

import java.util.Arrays;

public class Oppgave7 {
    public static String flett(String s, String t){
        String[] sa = s.split("");
        String[] ta = t.split("");
        String st = "";

        int i = 0, j = 0;

        while (i < sa.length && j < ta.length){
            st += sa[i++];
            st += ta[j++];
        }
        //Tar med resten
        while (i < s.length()) st += sa[i++];
        while (j < t.length()) st += ta[j++];

        return st;
    }

    public static String flett(String... s){
        if(s.length == 0){
            return "";
        }
        String ut = "";
        boolean check = true;
        int i = 0;
        while(check) {
            check = false;
            for (int j = 0; j < s.length; j++) {
                String[] as = s[j].split("");
                if(as.length > i) {
                    ut += as[i];
                    check = true;
                }
            }
            i++;
        }
        return ut;
    }

    public static void main(String[] args){
        String[] s = {"abe", "cd"};

        System.out.println(flett(s));
    }


    public static String flettMedSB(String s, String t){
        //int k = Math.min(s.length(), t.length());  // lengden på den korteste
        //StringBuilder sb = new StringBuilder();

        StringBuilder c = new StringBuilder(s.length() + t.length());  // en tabell av rett størrelse
        int i = 0, j = 0;                 // løkkevariabler

        while (i < s.length() && j < t.length()){

            c.append(s.charAt(i++)).append(t.charAt(j++));
        }
        //Tar med resten
        while (i < s.length()) c.append(s.charAt(i++));
        while (j < t.length()) c.append(t.charAt(j++));

        /*for (int i = 0; i < k; i++)
        {
            sb.append(s.charAt(i)).append(t.charAt(i));
        }

        sb.append(s.substring(k)).append(t.substring(k));*/

        return c.toString();
    }

}
