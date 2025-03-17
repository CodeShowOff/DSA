public class FloorInSortedArray {
    static int findFloor(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                ans = mid - 1;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
