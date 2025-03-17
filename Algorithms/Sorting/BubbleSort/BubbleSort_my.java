import java.util.Arrays;
// Time Complexity : O(N^2) - average, worst case and  O(N) - best case
public class BubbleSort_my {
    public static void main(String[] args) {

        int arr[]= {5,3,6,7,9,1,2,4,8};

        for (int i = 0; i < arr.length-1; i++) {
            boolean didSwap = false; // for optimization
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr [j]> arr[j+1]){
                    // swap:
                    int temp=arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                    didSwap = true;
                }
            }
            if(! didSwap){ // if no swapping done then array is sorted now
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
