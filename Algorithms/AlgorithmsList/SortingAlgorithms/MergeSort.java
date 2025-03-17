/*
  Merge Sort Algorithm (Divide and Conquer)

  Purpose:
  Merge Sort is a stable, comparison-based sorting algorithm that follows the divide-and-conquer strategy.
  It divides the array into two halves, recursively sorts each half, and then merges them back together
  in a sorted manner.

  Need:
  Merge Sort is widely used when stability is required and in cases where Quick Sort's worst-case 
  performance is a concern. It is particularly useful for sorting linked lists and large datasets.

  Time Complexity:
  - Best/Average/Worst Case: O(n log n) → Each level of recursion takes O(n), and there are log n levels.
  
  Space Complexity:
  - O(n) → Additional space is required for merging the subarrays.
*/

public class MergeSort {

    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    static void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

/*
Explanation:
1. The array is recursively divided into two halves until the base case (single element) is reached.
2. The sorted halves are merged back together using the merge function.
3. The merging ensures that the combined array remains sorted.
4. This process is repeated recursively to form the final sorted array.
*/
