public class PalindromeNumber {

    // General Approach : TC:O(N)
    public boolean isPalindrome(int x) {
        int num = x;
        if(x < 0){
            return false;
        }
        int rev = 0;
        while(x > 0){
            rev = rev * 10 + x%10;
            x /= 10;
        }
        return num == rev;
    }

    // Smart Approach: TC:O(N/2)
    public boolean isPalindrome2(int x) {

        if(x < 0 || (x % 10 == 0 && x!=0)){
            return false;
        }
        int reverse =0;

        while(x > reverse){
            reverse = reverse  * 10 + x%10;
            x/=10;
        }
        return x==reverse || x==reverse/10;
    }
}

/*
Approach 2: Explanation:

### Key Points in the Code
1. **Handling Negative Numbers and Multiples of 10**
   ```java
   if(x < 0 || (x % 10 == 0 && x != 0)){
       return false;
   }
   ```
   - If `x` is negative (`x < 0`), it cannot be a palindrome because of the negative sign.
   - If `x` ends in `0` but is not `0` itself (`x % 10 == 0 && x != 0`), it cannot be a palindrome (e.g., `10` is not a palindrome).

2. **Reversing Half of the Number**
   ```java
   int reverse = 0;
   while(x > reverse){
       reverse = reverse * 10 + x % 10;
       x /= 10;
   }
   ```
   - **Goal:** Reverse only the last half of the digits of the number.
   - **How it works:**
     - `x % 10` gives the last digit of `x`.
     - Multiply `reverse` by `10` and add the last digit of `x` to build the reversed number digit by digit.
     - Divide `x` by `10` to remove the last digit of `x`.
   - Stop the loop when `x` is no longer greater than `reverse`. At this point, half of the digits have been reversed.

3. **Checking for Palindrome**
   ```java
   return x == reverse || x == reverse / 10;
   ```
   - **Why two cases?**
     - When the number of digits is **even**, the reversed half (`reverse`) should exactly match the remaining half (`x`).
     - When the number of digits is **odd**, the middle digit doesn't affect the palindrome property. Thus, `reverse / 10` (ignoring the middle digit of the reversed half) should match the remaining half (`x`).

---

### Example Walkthroughs
#### Example 1: `x = 121`
- Initial values: `x = 121`, `reverse = 0`.
- First iteration:
  - `reverse = reverse * 10 + x % 10 = 0 * 10 + 121 % 10 = 1`
  - `x = x / 10 = 121 / 10 = 12`
- Second iteration:
  - `reverse = reverse * 10 + x % 10 = 1 * 10 + 12 % 10 = 12`
  - `x = x / 10 = 12 / 10 = 1`
- Loop exits (`x > reverse` condition fails: `1 > 12` is false).
- Check:
  - `x == reverse` is false (`1 != 12`).
  - `x == reverse / 10` is true (`1 == 12 / 10`).
- Return `true`.

#### Example 2: `x = -121`
- `x < 0`, so the method returns `false` immediately.

#### Example 3: `x = 10`
- `x % 10 == 0` and `x != 0`, so the method returns `false`.

---

### Time Complexity
- The number of iterations in the `while` loop is proportional to half the number of digits in `x`, making the time complexity \(O(\log_{10}(n))\), where \(n\) is the value of `x`.

### Space Complexity
- The space complexity is \(O(1)\) because no extra space is used other than the variables.

This method is efficient, concise, and avoids reversing the entire number, thus preventing overflow issues.
*/