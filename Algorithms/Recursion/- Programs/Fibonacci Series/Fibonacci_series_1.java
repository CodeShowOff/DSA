public class Fibonacci_series_1{

    static void fibonacci(int a, int b, int n){
        if(n==0)
            return;
        int c=a+b;
        System.out.print(c+" ");
        fibonacci(b, c, n-1);
    }
    public static void main(String[] args) {
        int a=0;
        int b=1;
        System.out.print(a+" "+b+" ");
        int no_of_terms=5;

        fibonacci(a,b,no_of_terms-2);
    }
    
}
