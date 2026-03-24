import java.util.ArrayList;
import java.util.Arrays;

public class Find_k_th_Prime {
    static boolean sieve[]= new boolean[86028121+1]; // Initial size:100000000  Modified size:86028121+1
    // We modified the length of seive after running the code once to save time and space and to avoid TLE.

    static ArrayList<Integer> primeNumbers = new ArrayList<>();

    static void prepareSieve(){ // Time Compkexity of this method (it will only run once): O(n*log(log n)) 
        
        // Fill all the value as true first in sieve:
        Arrays.fill(sieve, true);
        sieve[0]=sieve[1]=false; // because 0 and 1 are not prime numbers.

        int count=0; // to count how much prime numbers we found till sieve.length and decide do we really need 
                     // to go that much cause limit is 5000000
        int limit= 5*1000000; // because we have to find till 5000000-th prime numbers.(Constrant)

        for (int i = 2; i < sieve.length; i++) {
            if(sieve[i]==true){
                count++;
                primeNumbers.add(i);
                if(count==limit){
                    // System.out.println("size required for sieve: "+i); // Now, modify the size of sieve after getting output
                    break;
                }
                for (int j = i*2 ; j < sieve.length ; j+=i) {
                    sieve[j]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        prepareSieve();
        // finding k-th prime number: Time Complexity of finding: O(1)
        System.out.println(primeNumbers.get(1000000-1));
    }
}