package notater;

public class GenericsTest {
    public static void main(String[] args){
        Integer[] a = {1,8,9,18,98,2,3,9};
        Character[] b = {'A','C','K','Z','L','Y','M'};
        Person[] d = {new Person("Petter","Pettersen"), new Person("Kari","Pettersen"),new Person("Nils","Abra")};

        System.out.println(maks_generic(d));
    }

    public static class Person implements Comparable<Person> {
        String first_name;
        String last_name;

        public Person(String first_name, String last_name){
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public int compareTo(Person other){
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

    static
    <T extends Comparable<? super T>>
    int maks_generic(T[] values){
        T current_max = values[0];
        int current_index = 0;

        for(int i = 1; i < values.length; i++){
            //if(values[i] > current_index) {
            if(values[i].compareTo(current_max) > 0){
                current_max = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

    static int maks(int[] values){
        int current_max = values[0];
        int current_index = 0;
        for(int i = 1; i < values.length; ++i){
            if(values[i] > current_index) {
                current_index = values[i];
                current_index = i;
            }
        }
        return current_index;
    }

}
