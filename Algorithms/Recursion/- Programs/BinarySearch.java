package com.Codes.Recursion;

public class BinarySearch {
    public int binarySearch(int[] nums, int target, int low, int high){
        if(low > high){
            return -1;
        }

        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            return binarySearch(nums, target, low, mid - 1);
        }
        else{
            return binarySearch(nums, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,7,8,9};
        int target = 8;

        BinarySearch search = new BinarySearch();

        System.out.println(search.binarySearch(nums, target, 0, nums.length - 1));
    }
}
