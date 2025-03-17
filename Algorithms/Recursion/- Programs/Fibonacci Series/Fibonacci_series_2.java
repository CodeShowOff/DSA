public class Fibonacci_series_2 {
    // Recursive function to calculate the nth Fibonacci number
    static int fibonacci(int n) { // to find n-th fibonacci term.
        if (n <= 1) {
            return n; // Base case: F(0) = 0 for fibonacci(n - 2) , F(1) = 1 for fibonacci(n - 1).
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n=10;
        System.out.print("Fibonacci Series up to term " + n + ": ");
        for (int i = 0; i < n; ++i) { // to print all terms from 1 to 10.
            System.out.print(fibonacci(i) + " ");
        }
    }
}
// Explanation: fibonacci series ka n-th term uske (n-1)th term aur (n-2)th term ka sum hi toh hoga. like c= b+a