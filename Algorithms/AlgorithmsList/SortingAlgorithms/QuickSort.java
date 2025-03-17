/*
  Quick Sort Algorithm (Divide and Conquer)

  Purpose:
  Quick Sort is an efficient, in-place sorting algorithm that follows the divide-and-conquer strategy.
  It selects a 'pivot' element and partitions the array around it, ensuring that elements smaller 
  than the pivot come before it and elements greater than the pivot come after it. 
  This process is then recursively applied to the subarrays.

  Need:
  Quick Sort is widely used due to its efficiency, in-place sorting capability, and average-case 
  performance of O(n log n). It is preferred over Merge Sort in scenarios where memory usage is a concern.

  Time Complexity:
  - Best/Average Case: O(n log n) → Occurs when the pivot divides the array into roughly equal halves.
  - Worst Case: O(n^2) → Occurs when the pivot is always the smallest or largest element, causing unbalanced partitions.

  Space Complexity:
  - O(log n) in the average case (due to recursive calls).
  - O(n) in the worst case (if recursion depth reaches the size of the array).
*/

public class QuickSort {

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choosing the last element as the pivot
        int smallerElementIndex = low - 1; // Tracks the correct position of smaller elements

        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            if (array[currentIndex] <= pivot) {
                smallerElementIndex++;
                swap(array, smallerElementIndex, currentIndex);
            }
        }

        swap(array, smallerElementIndex + 1, high);
        return smallerElementIndex + 1;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/*
Explanation:
1. Select a pivot element (last element in this case).
2. Partition the array such that all elements smaller than the pivot are on the left 
   and all greater elements are on the right.
3. Recursively apply Quick Sort on the left and right subarrays.
4. The process continues until the entire array is sorted.
*/
