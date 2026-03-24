/*  
Classical approach to find all prime numbers from 1 to n.

Step-1: Mark every number as prime number
Step-2: Start with the smallest prime number, which is 2.
Step-3: Enumerate the multiples of this prime by counting in 
        increments of p from 2p up to n, and mark them as composite (not prime).
Step-4: Find the smallest unmarked number greater than p (if it exists). 
        Let this new number be the next prime, and repeat the process from step 3.
Step-5: Continue until there are no more unmarked numbers greater than p.

*/

// Time Complexity: O(n*log(log n))

import java.util.Arrays;

public class Sieve_Of_Eratosthenes {
    static int countPrimes(int num){

        int count=0;

        boolean primes[]= new boolean[num];
        Arrays.fill(primes, true); // All value true, i.e. all are primes.

        primes[0]=primes[1]=false; // because 0 and 1 are not prime numbers.

        for (int i = 2; i < num ; i++) {
            if(primes[i]){
                count++;
                // if any prime number found then its multiple wont't be prime so marking it's multiples as false.
                for (int j = i*2 ; j < num ; j+=i) {
                    primes[j]=false;
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(40));
    }
}
