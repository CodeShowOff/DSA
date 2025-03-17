/*
  Radix Sort Algorithm (Non-Comparison Sorting)

  Purpose:
  Radix Sort is a non-comparative sorting algorithm that sorts numbers digit by digit, starting 
  from the least significant digit to the most significant digit, using Counting Sort as a subroutine.

  Need:
  Radix Sort is useful when sorting integers or strings with fixed-length keys. 
  It is widely used in scenarios where the range of numbers is large but the number of digits is relatively small.

  Time Complexity:
  - Best/Average/Worst Case: O(nk) → Where n is the number of elements and k is the number of digits in the largest number.

  Space Complexity:
  - O(n + k) → Requires extra space for counting sort.
*/

public class RadixSort {

    static void radixSort(int[] array) {
        int max = findMax(array); // Find the maximum number to determine the number of digits

        // Perform counting sort for every digit, moving from least significant to most significant
        for (int placeValue = 1; max / placeValue > 0; placeValue *= 10) {
            countingSortByDigit(array, placeValue);
        }
    }

    static void countingSortByDigit(int[] array, int placeValue) {
        int size = array.length;
        int[] outputArray = new int[size];
        int[] countArray = new int[10]; // There are 10 possible digits (0-9)

        // Count occurrences of each digit at the current place value
        for (int num : array) {
            int digit = (num / placeValue) % 10;
            countArray[digit]++;
        }

        // Convert countArray into cumulative counts
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the sorted output array
        for (int i = size - 1; i >= 0; i--) {
            int digit = (array[i] / placeValue) % 10;
            outputArray[countArray[digit] - 1] = array[i];
            countArray[digit]--;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(outputArray, 0, array, 0, size);
    }

    // Utility method to find the maximum number in an array
    static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

/*
Explanation:
1. Find the largest number to determine the maximum number of digits.
2. Sort the numbers digit by digit, starting from the least significant digit.
3. Use Counting Sort as a subroutine for sorting based on each digit.
4. Repeat the process until all digits are processed, resulting in a fully sorted array.
*/
