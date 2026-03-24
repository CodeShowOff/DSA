public class GCD{
    // Method to compute GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b; 
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;

        int result = gcd(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
    }
}