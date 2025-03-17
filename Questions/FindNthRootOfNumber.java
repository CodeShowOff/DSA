public class FindNthRootOfNumber {
    public int nthRoot(int root, int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currNum = (int) currentRoot(mid, root);

            if(currNum == num){
                return mid;
            }

            if (currNum <= num) { // Avoids overflow
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public long currentRoot(int num, int pow){
        if(pow == 0){
            return 1;
        }

        long ans = 1;
        while(pow > 0){
            ans = ans * num;
            pow--;
        }
        return ans;
    }
}

// The above solution can result in overflow while calculating the current root, so the optimised solution is:
class FindNthRootOfNumber2{
    public int nthRoot(int root, int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currNum = currentRoot(mid, root, num);

            if(currNum == 0){
                return mid;
            }

            if (currNum == -1) { // Avoids overflow
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int currentRoot(int mid, int pow, int num){
        // return -1 : if ans < num
        // return 0 : if ans == num
        // return 1 : if ans > num
        long ans = 1;
        while(pow > 0){
            ans = ans * mid;
            if(ans > num){
                return 1;
            }
            pow--;
        }
        if(ans == num) return 0;
        else return -1;
    }
}
