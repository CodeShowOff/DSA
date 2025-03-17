public class FindFloorCeil {

    // For unsorted array;
    public int[] findFloorCeil1(int[] arr, int target) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num >= target) {
                ceil = Math.min(ceil, num);
            }
            if (num <= target) {
                floor = Math.max(floor, num);
            }
        }

        return new int[]{
                (floor == Integer.MIN_VALUE) ? -1 : floor,
                (ceil == Integer.MAX_VALUE) ? -1 : ceil
        };
    }

    // For sorted array (Using Binary Search)
    public int[] findFloorCeil2(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int floor = -1, ceil = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return new int[]{target, target}; // If exact match is found
            }
            else if (arr[mid] < target) {
                floor = arr[mid];  // Possible floor
                left = mid + 1;    // Move right to find a closer floor
            }
            else {
                ceil = arr[mid];   // Possible ceil
                right = mid - 1;   // Move left to find a closer ceil
            }
        }

        return new int[]{floor, ceil};
    }
}
