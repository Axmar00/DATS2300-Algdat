package notater.uke4generisk;

import java.util.Arrays;

public class VisitorPatternTest {

    public static class Personer{
        String first_name;
        String last_name;

        public Personer(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public String toString() {
            return first_name + " " + last_name;
        }
    }

    // Et interface - det lover at alle klasser som implementerer dette
    // har de forskrevne funksjonene.
    @FunctionalInterface
    public interface Komparator<T> {
        int compare(T a, T b);
    }

    public static class DescendingPersonComparator
            implements Komparator<Personer> {
        public int compare(Personer a, Personer b) {
            int last_compare = a.last_name.compareTo(b.last_name);
            if (last_compare == 0) {
                return a.first_name.compareTo(b.first_name);
            }
            else{
                return last_compare;
            }
        }
    }

    public static class AscendingPersonComparator
            implements Komparator<Personer> {
        public int compare(Personer a, Personer b) {
            int last_compare = b.last_name.compareTo(a.last_name);
            if (last_compare == 0) {
                return b.first_name.compareTo(a.first_name);
            }
            else{
                return last_compare;
            }
        }
    }

    public static class OddPartallKomparator
            implements Komparator<Integer> {
        public int compare(Integer a, Integer b) {
            //Først sammenlign "etternavnet => partall eller oddetall
            //Begge er partall eller begge er oddetall
            if (a % 2 == b % 2) {
                return a.compareTo(b);
            }
            //A er oddetall, B er partall
            else if (a % 2 > b % 2) {
                return 1;
            }
            //B er oddetall, A er partall
            else if (b % 2 > a % 2) {
                return -1;
            }
            //Not a number, infinity,etc. Burde kaste exception
            return 0;
        }
    }

    /*
    Denne funksjonen finner største verdi i values.
    Bruker sammenligningsfunksjonen i objektet comp for sammenligning.
     */
    public static <T> int maks(T[] values, int begin, int end, Komparator<T> comp){
        T current_max = values[begin];
        int current_index = begin;

        for (int i = begin + 1; i < end; i++) {
            //if(values[i] > current_index) {
            if (comp.compare(values[i],current_max) > 0) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }


    public static <T> void sort(T[] values, Komparator<T> comp) {
        //looper over alle untatt siste element
        for (int i = 0; i < values.length-1; ++i) {
            //finn største element i intervallet {1, a.length}
            int max_index = maks(values, i, values.length,comp);

            //bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[max_index];
            values[max_index] = temp;
        }
    }



    public static void main(String[] args) {
        Personer[] persons = {new Personer("Petter", "Pettersen"),
                new Personer("Kari", "Pettersen"),
                new Personer("Nils", "Abrahamsen"),
                new Personer("Tor","Toresen")};

        //Lager comparator-objektet.
        //Vi kan nå kjøre comp.compare(a,b)
        AscendingPersonComparator comp_asc = new AscendingPersonComparator();
        DescendingPersonComparator comp_des = new DescendingPersonComparator();

        //Lage sorteringsfunksjonen som tar inn både person-arrayet og en sammenligningsfunksjon
        System.out.println("Før sortering: " + Arrays.toString(persons));
        System.out.println("Sorterer!");
        sort(persons, comp_asc);
        System.out.println("Etter sortering (Ascending): " + Arrays.toString(persons));
        sort(persons, comp_des);
        System.out.println("Etter sortering (Descending): " + Arrays.toString(persons));

        Integer integers[] = {9,8,7,6,5,4,3,2,1,0};
        //Vil sortere sånn at vi får oddetall til venstre, partall til høyre
        //Partall og oddetall skal være inbyrdes sortert
        OddPartallKomparator odd_partall = new OddPartallKomparator();
        System.out.println("Før sortering: " + Arrays.toString(integers));
        //sort(integers,noe);
        sort(integers,odd_partall);
        System.out.println("Etter sortering: " + Arrays.toString(integers));

        //Partall og oddetallssjekk
        //Skille mellom partall og oddetall
        //Tanke: Bruk "er det partall" som "etternavn" og størrelse på tallet som "fornavn"
        //"noe" må være en komparator<T>


    }
}

