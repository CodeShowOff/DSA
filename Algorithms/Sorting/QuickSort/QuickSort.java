import java.util.Arrays;
// Working Principle: Divide and Merge
// Time Complexity: O(N*logN)

public class QuickSort {
    void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int pivot = findPivot(arr, low, high);

        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    int findPivot(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (arr[i] >= pivot && i <= high - 1){
                i++;
            }
            while (arr[j] < pivot && j >= low + 1) {
                j--;
            }
            
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j; // The pivot will be at this index
    }
    public static void main(String[] args) {
        QuickSort obj = new QuickSort();

        int arr[]= {5,3,7,9,1,2,6,4,8};
        obj.sort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}