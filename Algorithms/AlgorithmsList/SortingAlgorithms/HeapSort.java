/*
  Heap Sort Algorithm (Comparison-based Sorting)

  Purpose:
  Heap Sort is an efficient sorting algorithm that uses a Binary Heap data structure to sort elements.
  It converts the array into a max heap, repeatedly extracts the maximum element, and places it in the correct position.

  Need:
  Heap Sort is useful when we need an in-place sorting algorithm with O(n log n) worst-case performance.
  It is widely used in applications like priority queues and scheduling problems.

  Time Complexity:
  - Best/Average/Worst Case: O(n log n) → Heap construction takes O(n), and extracting elements takes O(log n) per element.

  Space Complexity:
  - O(1) → It is an in-place sorting algorithm and does not require extra memory.
*/

public class HeapSort {

    static void heapSort(int[] array) {
        int size = array.length;

        // Build max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

        // Extract elements from heap one by one
        for (int i = size - 1; i > 0; i--) {
            swap(array, 0, i); // Move current root to end
            heapify(array, i, 0); // Heapify the reduced heap
        }
    }

    static void heapify(int[] array, int size, int rootIndex) {
        int largest = rootIndex; // Assume root is the largest
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < size && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            swap(array, rootIndex, largest);
            heapify(array, size, largest); // Recursively heapify the affected subtree
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/*
Explanation:
1. Convert the array into a max heap (each parent node is greater than its children).
2. Extract the largest element (root) and place it at the end of the array.
3. Heapify the remaining elements to maintain the max heap structure.
4. Repeat the process until the entire array is sorted.
*/
