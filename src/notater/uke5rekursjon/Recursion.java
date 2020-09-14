package notater.uke5rekursjon;

public class Recursion {

    /**
     * This function calculates n!(n factiorial) using a recursive function call.
     * @param n - Value to compute the factorial of
     * @return n! - n factorial
     */

    static int factorial(int n){
        if(n == 1){             //basistilfelle
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    static int recursiveFunction(int value){
        System.out.println(value);

        if(value <= 5){  //basistilfelle
            return -9;
        }

        else {
            return recursiveFunction(value-1); //basistilfelle endres
        }
    }

    public static void main(String[] args) {

    }
}
