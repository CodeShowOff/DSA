public class NumberOfOccurenceOfTargetInSortedArray {
    int countFreq(int[] arr, int target) {
        return searchRange(arr, target);
    }
    public int searchRange(int[] nums, int target) {

        int first = search(nums, target, true);
        if(first == -1){ // if the target not found
            return 0;
        }
        int last = search(nums, target, false);

        return last - first + 1;
    }
    public int search(int[] arr, int target, boolean isLeft){
        int left = 0;
        int right = arr.length - 1;
        int foundAt = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                foundAt = mid;
                if(isLeft){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(target > arr[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return foundAt;
    }
}
