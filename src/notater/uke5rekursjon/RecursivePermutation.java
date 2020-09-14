package notater.uke5rekursjon;

import java.util.Arrays;

public class RecursivePermutation {

    public static void main(String[] args) {

        int[] values = {1,2,3};
        recursive_permutation(values,0);
    }

    public static void recursive_permutation(int[] values, int k){
        if(k == values.length-1){
            System.out.println(Arrays.toString(values));
        }

        for(int i = k; i < values.length; i++){
            swap(values, i, k);
            recursive_permutation(values,k+1);
            swap(values, k, i);
        }
    }
    public static void swap(int[] a, int m, int n){
        int temp = a[m]; a[m] = a[n]; a[n] = temp;
    }
}
