import java.util.Arrays;
// Time Complexity : O(N^2) - best, average, worst case
public class SelectionSort_my {

    public static void main(String[] args) {
        
        int arr[]= {5,3,6,7,9,1,2,4,8};

        for (int i = 0; i < arr.length-1; i++) {
            int minimum = i; // lets assuma minimum is at index i.
            for (int j = i; j < arr.length; j++) {
                if(arr[j]< arr[minimum]){
                    minimum = j;
                }
            }
            // swapping
            int temp= arr[i];
            arr[i]= arr[minimum];
            arr[minimum]= temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}