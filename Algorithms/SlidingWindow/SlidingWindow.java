public class SlidingWindow {

    // This program prints the sum of all subarrays of the specified window size
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Input array
        int window = 3; // Window size

        int i = 0, j = 0; // Pointers to define window
        int sum = 0;      // Variable to store current window sum

        while (j < arr.length) {
            sum += arr[j]; // Add the current element to the sum

            // If window size is reached
            if (j - i + 1 == window) {
                System.out.println(sum); // Print the current window sum
                sum -= arr[i];           // Remove the element going out of the window
                i++;                     // Slide the window forward
            }

            j++; // Move the end of the window
        }
    }
}
