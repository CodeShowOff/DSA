public class PrimeNumber_3 {
    static boolean isPrime(int num){

        if(num<=1)
            return false;
        
        if(num==2 || num==3)
            return true;
        
        if(num%2==0 || num%3==0) // nums are greater than 2 and 3 so now 2 and 3 should not be factor of num
            return false;
        

        // checking till square root of the number:
        for (int i = 5; i*i <= num; i=i+2) { //  'i <= sqrt(num)'  if we square both side it is: 'i*i <= num'
            if(num%i == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int num=5;
        boolean isPrime=isPrime(num);
        System.out.println(isPrime);
    }
}
// note: using sqrt(num) should be avoided because: the sqrt() has a time complexity of log n. 
// so, it will make the tatal complexity  sqrt(num)*log n , so we should avoid using it.