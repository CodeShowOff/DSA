/*
  Counting Sort Algorithm (Non-Comparison Sorting)

  Purpose:
  Counting Sort is a non-comparison-based sorting algorithm that sorts an array by counting the occurrences 
  of each element and placing them in the correct order.

  Need:
  Counting Sort is useful for sorting integers within a known range efficiently. 
  It is often used when sorting large datasets with limited distinct values, such as age groups or frequency analysis.

  Time Complexity:
  - Best/Average/Worst Case: O(n + k) → Where n is the number of elements and k is the range of input values.

  Space Complexity:
  - O(k) → Requires extra space for the count array.
*/

public class CountingSort {

    static void countingSort(int[] array) {
        int max = findMax(array); // Find the maximum value in the array
        int min = findMin(array); // Find the minimum value in the array
        int range = max - min + 1; // Determine the range of values

        int[] countArray = new int[range]; // Array to store counts
        int[] outputArray = new int[array.length]; // Output array to store sorted elements

        // Count occurrences of each element
        for (int num : array) {
            countArray[num - min]++;
        }

        // Update countArray to store cumulative counts
        for (int i = 1; i < range; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the sorted output array
        for (int i = array.length - 1; i >= 0; i--) {
            outputArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(outputArray, 0, array, 0, array.length);
    }

    // Utility method to find maximum value in an array
    static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Utility method to find minimum value in an array
    static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}

/*
Explanation:
1. Create a count array to store occurrences of each value.
2. Convert count array into a cumulative sum array to determine positions.
3. Place elements into the output array using their correct positions.
4. Copy the sorted output array back to the original array.
*/
