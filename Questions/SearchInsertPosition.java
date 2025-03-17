public class SearchInsertPosition {
    public int searchInsertPosition(int[] nums, int target) {
        int Index=-1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                Index=m;
                break;
            }
            if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        if(Index==-1)
            return l;
        return Index;
    }
}
