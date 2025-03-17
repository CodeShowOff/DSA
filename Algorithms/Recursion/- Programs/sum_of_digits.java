public class sum_of_digits {
    static int findSum(int num){
        if(num==0)
            return 0;

        int x=num%10;

        return x + findSum(num/10);
    }
    public static void main(String[] args) {
        System.out.println(findSum(12345));
    }
}
