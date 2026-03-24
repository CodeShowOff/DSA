import java.util.Arrays;

public class Minimum_Prime_factor {
    static int N=1000000;
    static int sieve[]= new int[N+1];

    static void createSieve(){
        Arrays.fill(sieve, 1);
        sieve[0]=sieve[1]=0;
        
        for (int i = 2; i*i < sieve.length; i++) {
            if(sieve[i]==1){
                for (int j = i*i; j < sieve.length; j+=i) {
                    if(sieve[j] !=0 ){
                        sieve[i]++;
                        sieve[j]=0;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        createSieve();
        System.out.println(sieve[7]);
    }
}
