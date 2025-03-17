public class ContainerWithMostWater{

    // BruteForce Approach: TC:O(N^2) , also TLE in LeetCode
    public static int maxArea(int[] height) {
        int result=0;

        int n = height.length;
        int area = 0;
        for (int i = 0; i < n; i++) {

            area = 0;
            for (int j = i; j < n; j++) {

                int firstBound = height[i]; // 8
                int secondBound = height[j];
                int minBound = Integer.min(firstBound, secondBound);

                area = minBound * (j-i);
                result = Math.max(area, result);
            }
        }
        return result;
    }

    // Better Approach (Two-Pointer): TC:O(N)
    public int maxArea2(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxWater = 0;

        while(i < j){
            int firstBound = height[i]; // 8
            int secondBound = height[j];
            int minBound = Integer.min(firstBound, secondBound);

            int area = minBound * (j-i);
            maxWater = Math.max(area, maxWater);

            if(firstBound == minBound){
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }

    // Best Approach (same as above but with better optimization) :
    public static int maxArea3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, h * (right - left));

            while(left < right && height[left] <= h) {
                left++;
            }
            while(left < right && height[right] <= h) {
                right--;
            }
        }
        return maxWater;
    }
}