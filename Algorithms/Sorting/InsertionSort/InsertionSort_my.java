import java.util.Arrays;
// Time Complexity : O(N^2) - average, worst case and  O(N) - best case
public class InsertionSort_my {
    public static void main(String[] args) {
        
        int arr[]= {5,3,6,7,9,1,2,4,8};

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]){
                for (int j = i+1; j > 0 && arr[j] < arr[j-1]; j--) {
                    int temp= arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1]= temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}