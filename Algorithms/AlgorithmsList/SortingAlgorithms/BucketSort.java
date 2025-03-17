/*
  Bucket Sort Algorithm (Non-Comparison Sorting)

  Purpose:
  Bucket Sort is a distribution-based sorting algorithm that distributes elements into multiple 
  buckets, sorts each bucket individually (using another sorting algorithm, like Insertion Sort), 
  and then concatenates the sorted buckets to form the final sorted array.

  Need:
  Bucket Sort is useful when dealing with uniformly distributed floating-point numbers or integers 
  within a known range. It is commonly used in applications like external sorting and graphics.

  Time Complexity:
  - Best Case: O(n + k) → When elements are evenly distributed across buckets and each bucket is efficiently sorted.
  - Average Case: O(n + k) → Depends on the distribution of elements and the sorting algorithm used for buckets.
  - Worst Case: O(n²) → When all elements fall into one bucket and sorting is done using a quadratic algorithm like Insertion Sort.

  Space Complexity:
  - O(n + k) → Extra space is required for the buckets.
*/

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    static void bucketSort(float[] array) {
        int bucketCount = array.length; // Number of buckets
        ArrayList<Float>[] buckets = new ArrayList[bucketCount];

        // Initialize empty buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (float num : array) {
            int bucketIndex = (int) (num * bucketCount); // Hashing function
            buckets[bucketIndex].add(num);
        }

        // Sort each bucket individually
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate sorted buckets back into the original array
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                array[index++] = num;
            }
        }
    }
}

/*
Explanation:
1. Create empty buckets.
2. Distribute elements into buckets based on a hashing function.
3. Sort each bucket using a suitable sorting algorithm (here, Collections.sort is used).
4. Merge all sorted buckets to form the final sorted array.
*/
