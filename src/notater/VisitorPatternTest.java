package notater;

import java.util.Arrays;

public class VisitorPatternTest {

    public static class Personer implements Comparable<Personer> {
        String first_name;
        String last_name;

        public Personer(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public String toString() {
            return first_name + " " + last_name;
        }

        @Override
        public int compareTo(Personer o) {
            return 0;
        }
    }

    @FunctionalInterface
    public interface Komparator<T> {
        int compare(T a, T b);

    }

    public static class AscendingPersonComparator
            implements Komparator<VisitorPatternTest.Personer> {
        public int compare(VisitorPatternTest.Personer a, VisitorPatternTest.Personer b) {
            int last_compare = a.last_name.compareTo(b.last_name);
            if (last_compare == 0) {
                return a.first_name.compareTo(b.first_name);
            }
            return last_compare;

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
            //Not a number, infinity,etc. Burde kast exception
            return 0;
        }
    }


    public static <T> void sort(T[] a, Komparator<T> comp) {

    }

    public static void main(String[] args) {
        VisitorPatternTest.Personer[] persons = {new VisitorPatternTest.Personer("Petter", "Pettersen"),
                new VisitorPatternTest.Personer("Kari", "Pettersen"),
                new VisitorPatternTest.Personer("Nils", "Abrahamsen")};

        AscendingPersonComparator comp_asc = new AscendingPersonComparator();

        System.out.println("Før sortering: " + Arrays.toString(persons));
        System.out.println("Sorterer!");
        sort(persons, comp_asc);
        System.out.println("Etter sortering: " + Arrays.toString(persons));
    }
}

