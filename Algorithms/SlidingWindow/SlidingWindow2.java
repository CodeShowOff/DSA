import java.util.ArrayList;
import java.util.List;
public class SlidingWindow2 {
    // Calculates the sum of each subarray of a given window size
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int windowSize = 3;

        List<Integer> windowSums = getSlidingWindowSums(arr, windowSize);

        // Output the results
        for (int sum : windowSums) {
            System.out.println(sum);
        }
    }

    public static List<Integer> getSlidingWindowSums(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int windowSum = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            // Start subtracting elements once the window is fully formed
            if (i >= k - 1) {
                result.add(windowSum); // Add current window sum to result
                windowSum -= arr[i - k + 1]; // Remove the element that's sliding out
            }
        }

        return result;
    }
}
