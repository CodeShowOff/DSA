public class PrimeFactorization_Optimized {
    // Time COmplexity: O(sqrt(N))
    public static void main(String[] args) {
        int num=37;

        // To find prime factorization:
        for(int i=2; i<=num; i++){// because every number has a prime factor that is lesser than equal to sqrt(number). 
            if(num%i==0){
                while(num%i==0){
                    System.out.print(i+" ");
                    num=num/i;
                }
            }
        }
        if(num>1)
            System.out.println(num);
    }
}
