public class Sum_of_first_n_natural_numbers {
    // Method-1
    static int findSum(int n){
        if(n==0)
            return 0;
        return n + findSum(n-1);
    }

    // Method-2
    static void findSum2(int i, int n, int sum){
        if(i>n){
            System.out.println(sum);
            return;
        }
        sum+=i;
        findSum2(i+1, n, sum);
    }
    // Method-3
    static int sum=0;
    static void sum_of_first_N_nums(int n){
        if (n==0){
            System.out.println(sum);
            return;
        }
        sum+=n;
        sum_of_first_N_nums(n-1);
    }
    public static void main(String[] args) {
    // Method-1
        int result=findSum(5);
        System.out.println(result);

    // Method-2
        findSum2(1,5,0);

    // Method-3
        sum_of_first_N_nums(5);
    }
}


