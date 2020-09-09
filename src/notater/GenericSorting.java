package notater;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericSorting {
    public static void main(String[] args) {
        Integer[] a = {1, 8, 9, 18, 98, 2, 3, 9};
        Character[] b = {'A', 'C', 'K', 'Z', 'L', 'Y', 'M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};
        Personer[] d = {new Personer("Petter", "Pettersen"), new Personer("Kari", "Pettersen"), new Personer("Nils", "Abrahamsen")};
        int person_max_index = maks(d, 0, d.length);

        System.out.println("Siste person, leksigografisk, er " + d[person_max_index]);

        System.out.println("Sorterer personer");

        System.out.println("Før:" + Arrays.toString(d));
        sort(d);
        System.out.println(Arrays.toString(d));
    }

    public static class Personer implements Comparable<Personer> {
        String first_name;
        String last_name;

        public Personer(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }


        public int compareTo(Personer other){
            /*
            if(this.last_name < other.last.name){
            return -1;
            }else if(this.last_name == other.last_name){
            return 0;
            }else{
            return 1;
            }
             */
            int last_compare = this.last_name.compareTo(other.last_name);
            if(last_compare == 0){
                return this.first_name.compareTo(other.first_name);
            }
            else{
                return last_compare;
            }
        }
    }



    static <T extends Comparable<? super T>>
    void sort(T[] values) {
        //looper over alle untatt siste element
        for (int i = 0; i < values.length-1; i++) {
            //finn største element i intervallet {1, a.length}
            int max_index = maks(values, i, values.length);

            //bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[max_index];
            values[max_index] = temp;
        }
    }

    static <T extends Comparable<? super T>>
    int maks(T[] values, int begin, int end) {
        T current_max = values[0];
        int current_index = begin;

        for (int i = begin + 1; i < end; i++) {
            //if(values[i] > current_index) {
            if (values[i].compareTo(current_max) > 0) {
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }
}
