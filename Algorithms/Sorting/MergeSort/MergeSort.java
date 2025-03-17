import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort{
    // Working Principle: Divide and Merge
    // Time Complexity: O(N*logN)

    void sort(int[] arr, int low, int high){
        if( low >= high){
            return;
        }
        int mid= (low + high)/2;
        // for first half:
        sort( arr, low, mid);
        // for second half:
        sort( arr, mid+1, high);
        // now merge:
        merge(arr, low, mid, high);
    }

    void merge(int[] arr, int low, int mid, int high){
        // Finding two pointers:
        int left = low;
        int right = mid+1;

        ArrayList<Integer> temp = new ArrayList<>(high - low + 1);

        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        
        while (left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i]= temp.get(i - low);
        }

         
    }
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();

        int[] arr = {5,3,6,7,9,1,2,6,4,8,1};
        obj.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
