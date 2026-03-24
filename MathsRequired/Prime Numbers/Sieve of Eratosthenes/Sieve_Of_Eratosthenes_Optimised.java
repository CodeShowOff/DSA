// Time Complexity: O(n*log(log n))

import java.util.Arrays;

public class Sieve_Of_Eratosthenes_Optimised {
    static int countPrimes(int num){

        int count=0;

        boolean primes[]= new boolean[num];
        // All value true, i.e. all are primes.
        Arrays.fill(primes, true);

        primes[0]=primes[1]=false; // because 0 and 1 are not prime numbers.

        for (int i = 2; i < num ; i++) { // Optimization-1
            if(primes[i]){
                count++;
                // if any prime number found then its multiple wont't be prime so marking it's multiples as false.
                for (int j = i*i ; j < num ; j+=i) { // Optimization-2
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

/*
Optimization Explanation:

In the given **Sieve of Eratosthenes** implementation, the use of **i*i** in lines 16 and 20 is crucial for optimizing the algorithm. Let's break down the logic and understand why:

1. **Initialization (Line 16)**:
   - We start with an array `primes[]` where all values are initially set to `true`, indicating that all numbers are considered prime.
   - The loop iterates from `i = 2` up to `i*i < num` (where `num` is the input limit).
   - Why `i*i`? Because any number greater than `sqrt(num)` will have its factors already marked as non-prime by smaller prime numbers. So, we only need to check up to `sqrt(num)`.

2. **Marking Multiples (Line 20)**:
   - When we find a prime number (i.e., `primes[i]` is `true`), we increment the `count` and mark its multiples as non-prime.
   - The inner loop iterates from `j = i*i` up to `j <= num`, incrementing `j` by `i` each time.
   - Why `i*i`? At `i*i`, we get the first unmarked position. All previous multiples of `i` (i.e., `i*2`, `i*3`, ..., `i*(i-1)`) have already been marked as non-prime by smaller prime numbers.

**Example**:
Suppose we are finding primes up to `num = 40`. Let's consider `i = 5`:
- `i*i = 25`
- We mark `25`, `30`, `35`, and `40` as non-prime because they are multiples of `5`.
- We skip checking `5*2`, `5*3`, and `5*4` because they have already been marked by smaller primes (e.g., `2`, `3`, and `4`).
    
Also, for ex- 20 : we know "5 * 4 = 20" ; since 20 is also a factor of 4 so when "i" would have been 4 it would have already marked 20 as false, so we do not need to check for numbers less then square of 'i'.

This optimization significantly reduces the number of iterations and improves the efficiency of the algorithm. It ensures that we only check relevant multiples of each prime number, leading to a faster computation of prime counts. 🚀
 */