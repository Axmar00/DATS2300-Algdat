package notater.uke5rekursjon;

public class BinarySearch {
    public static void main(String[] args) {
        int[] values = {1,2,4,8,17,19,22};
        System.out.println(binarySearch(22,values,0,values.length-1));

    }

    //Search in the interval [left, right].
    //Will return 0 if the value is less than values[0]
    static int binarySearch(int searchValue, int[] values, int left, int right){
        int mid = (left+right)/2;

        if(right - left == 0){
            if(values[mid] == searchValue){
                return mid;
            }
            return -mid;
        }

        if(values[mid] <= searchValue ){
            if(values[mid] == searchValue){
                return mid;
            }
            return binarySearch(searchValue,values,mid+1,right);
        }
        else{
            return binarySearch(searchValue,values,left,mid-1);
        }
    }



}
