import java.util.HashMap;

public class Longest_Subarray_sum {
    // better approach -> Time Complexity ~ O(N^2) & Space Complexity O(N): By Hashing and Prefix Sum concept 
    // Also works if array have negatives and its the optimal approach if array have negatives:
    static void findSubArrayLength(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0; 

        for (int i = 0; i < arr.length; i++) {
            //calculate the prefix sum till index i:
            prefixSum += arr[i];

            if(prefixSum == k){
                maxLength = Integer.max(maxLength, i+1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int remaining = prefixSum - k;

            // update maxLength:
            if (map.containsKey(remaining)) {
                int len = i - map.get(remaining);
                maxLength = Integer.max(maxLength, len);
            }
            //Finally, update the map checking the conditions:
            if (! map.containsKey(prefixSum)) { // To count zeroes also in length because we need to find the maximum length
                map.put(prefixSum, i);
            }
        }
        System.out.println(maxLength);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 3;

        findSubArrayLength(arr, k);
    }
}
