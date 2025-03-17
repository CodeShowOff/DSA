import java.util.Arrays;

public class FindDownSlope {
    // Question: To count number of down slopes and longest length of a down slope
    public static int[] findDownSlope(int[] arr) {
        int countDownSlope = 0;
        int maxLen = 0;

        for (int i = 1; i < arr.length; i++) {
            int tempLen = 1;

            if (arr[i - 1] > arr[i]) {
                countDownSlope++;

                while (i < arr.length && arr[i - 1] > arr[i]) {
                    tempLen++;
                    i++;
                }

                maxLen = Math.max(maxLen, tempLen);
            }
        }
        return new int[]{maxLen, countDownSlope};
    }

    public static void main(String[] args) {
        int[] result = findDownSlope(new int[]{1,2,3,11,10,9,5,6,4,8,1});
        System.out.println(Arrays.toString(result));
    }
}
