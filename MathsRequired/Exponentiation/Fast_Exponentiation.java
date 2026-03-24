public class Fast_Exponentiation {
    public static void main(String[] args) {
 
        int result=1;
    
        int x=2, n=8;
    
            while(n>0){
                if((n & 1)==1){ // This will run at first if n=odd and at last when n=1.
                    result*=x;
                }
                x=x*x;  // its increasing exponentially
                n=n>>1; // its decreasing exponentially
            }
            System.out.println(result);      
    }
}

/*
Explanation:
Certainly! Let's break down the logic of the given **Fast Exponentiation** code:

1. **Objective**: The goal of this code is to calculate the value of \(x^n\) efficiently, where \(x\) is a base integer and \(n\) is a non-negative integer exponent.

2. **Approach**: The code uses an optimized method to compute \(x^n\) by exploiting the binary representation of \(n\).

3. **Explanation**:
    - Initialize `result` to 1. This variable will store the final result.
    - Set `x` to 2 (the base) and `n` to 8 (the exponent) in this example.
    - The `while` loop runs as long as `n` is positive (greater than 0).
    - Inside the loop:
        - Check if the least significant bit of `n` is 1 (i.e., `n & 1 == 1`). If true, multiply `result` by `x`. This step handles the odd powers of \(x\).
        - Square `x` (i.e., `x = x * x`). This step doubles the exponent (increases it exponentially).
        - Right-shift `n` by 1 (i.e., `n = n >> 1`). This step halves the exponent (decreases it exponentially).
    - Repeat the above steps until `n` becomes 0.
    - Finally, print the value of `result`.

4. **Execution**:
    - Initially, `result = 1`, `x = 2`, and `n = 8`.
    - Iteration 1: Since `n` is even, `result` remains unchanged, `x` becomes 4 (2 * 2), and `n` becomes 4 (right-shift by 1).
    - Iteration 2: Since `n` is even, `result` remains unchanged, `x` becomes 16 (4 * 4), and `n` becomes 2.
    - Iteration 3: Since `n` is even, `result` remains unchanged, `x` becomes 256 (16 * 16), and `n` becomes 1.
    - Iteration 4: Since `n` is odd (least significant bit is 1), multiply `result` by `x`, resulting in `result = 256`, and `n` becomes 0.
    - The loop terminates.
    - The final result is 256.

5. **Output**:
    - When you run this code, it will print `256`.

In summary, this code efficiently calculates \(2^8\) using bitwise operations and exponentiation by squaring, making it faster than the naive approach of multiplying \(x\) repeatedly by itself \(n\) times.
 */