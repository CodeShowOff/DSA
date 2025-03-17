public class FindNumberOfRotationOfSortedArray {
    public int findKRotation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        int low = 0;
        int high = nums.length;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] < min){
                index = mid;
                min = nums[mid];
            }

            // left portion is sorted:
            if(nums[low] <= nums[mid]){
                if(nums[low] < min){
                    index = low;
                    min = nums[low];
                }
                low = mid + 1;
            }

            // right portion is sorted:
            else{
                if(nums[mid] < min){
                    index = mid;
                    min = nums[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
