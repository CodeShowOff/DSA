// Brute force method: Time Complexity= O(N)

public class PrimeNumbers_1 {

    static boolean isPrime(int num){

        if(num<=1)
            return false;

        for (int i = 2; i < num ; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int num=2;
        boolean isPrime=isPrime(num);
        System.out.println(isPrime);
    }
}