// Brute force method with less no of checks: Time Complexity= O(sqrt(N))

public class PrimeNumber_2 {
    static boolean isPrime(int num){

        if(num<=1)
            return false;

        // checking till square root of the number:
        for (int i = 2; i*i <= num; i++) { //  'i <= sqrt(num)'  if we square both side it is: 'i*i <= num'
            if(num%i == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int num=8;
        boolean isPrime=isPrime(num);
        System.out.println(isPrime);
    }
}
// note: using sqrt(num) should be avoided because: the sqrt() has a time complexity of log n. 
// so, it will make the tatal complexity  sqrt(num)*log n , so we should avoid using it.