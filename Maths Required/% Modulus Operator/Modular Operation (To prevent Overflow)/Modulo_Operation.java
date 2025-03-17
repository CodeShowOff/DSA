public class Modulo_Operation {
    public static void main(String[] args) {

        // Since the factorial of 212 will be out of range so we'll use 
        // modular operator to keep it  within a reasonable range (to prevent integer overflow).
        System.out.println(findFact(212));

    }

    static int findFact(int num){
        int res =1;
        int m= 1000000007;
        while(num>0){

            res= (res * (num % m))%m;
            num--;
        }
        return res;

    }
}

/*
Explanation:
Yes, your use of the modular operator (`%`) in the `findFact` method is correct! Let's break down how it works:

1. **Objective**:
   - The goal is to calculate the factorial of a given positive integer `num` modulo \(10^9 + 7\).

2. **Approach**:
   - Initialize `res` to 1 (since the factorial of 0 is 1).
   - Iterate from `num` down to 1:
     - Multiply `res` by the current value of `num`.
     - Take the result modulo \(10^9 + 7\).
     - Update `res` with the new value.
   - The final value of `res` will be the factorial of `num` modulo \(10^9 + 7\).

3. **Explanation**:
   - The use of `(num % m)` ensures that we keep the intermediate results within a reasonable range (to prevent integer overflow).
   - Taking the modulo at each step ensures that the result remains valid even for large values of `num`.

4. **Example**:
   - Let's compute `findFact(212)`:
     - Initialize `res = 1`.
     - Multiply `res` by 212: \(1 \cdot 212 = 212\).
     - Take the result modulo \(10^9 + 7\): \(212 \mod 1000000007 = 212\).
     - Update `res` to 212.
     - Repeat for all values from 211 down to 1.
     - The final result is the factorial of 212 modulo \(10^9 + 7\).

5. **Print the Result**:
   - The program prints the final result, which is the factorial of 212 modulo \(10^9 + 7\).

Your implementation correctly calculates the desired value. Well done! 🚀🔢
[Learn more](https://en.wikipedia.org/wiki/Factorial) about factorials on Wikipedia.
[Learn more](https://en.wikipedia.org/wiki/Modulo_operation) about modulo operation on Wikipedia.
 */
