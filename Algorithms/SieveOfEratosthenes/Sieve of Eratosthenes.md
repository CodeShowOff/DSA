Good question 👍

Your implementation is basically the **Sieve of Eratosthenes**, which is already very efficient compared to naïve primality checking. However, it can be optimized further both in **time** and **space**:

---

### 🔎 Issues with current code

1. **Inner loop starts at `i + i`:**

   * You are marking multiples starting from `2*i`.
   * But all multiples below `i*i` would already have been marked by smaller primes.
   * Starting from `i*i` reduces redundant work.

2. **Redundant checks beyond `sqrt(n)`:**

   * Once `i > sqrt(n)`, there’s no need to mark multiples.
   * Because any composite `c` must have a factor ≤ `sqrt(c)`.

3. **Space optimization:**

   * You’re using a `boolean[n]`, which is fine, but can be halved if you skip even numbers.

---

### ⚡ Optimized Code

```java
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0; // 0 and 1 are not primes

        boolean[] isComposite = new boolean[n];
        int count = n / 2; // Assume half of numbers < n are prime (skip evens)

        for (int i = 3; i * i < n; i += 2) { // skip even i
            if (!isComposite[i]) {
                for (int j = i * i; j < n; j += 2 * i) { // skip even multiples
                    if (!isComposite[j]) {
                        isComposite[j] = true;
                        count--;
                    }
                }
            }
        }

        return count;
    }
}
```

---

### ✅ Why this is faster:

1. **Start at `i*i`:** avoids redundant markings.
2. **Skip evens:** halves the array operations.
3. **Count initialized with odds:** removes unnecessary prime checks.

⏱️ Time complexity: **O(n log log n)** (same as your version, but with fewer operations).
📦 Space complexity: **O(n)**, can be halved further if you only store odds.

---

👉 Your version works well, but this one is more optimized in practice.

Do you want me to also show you a **memory-efficient bitset version** (instead of `boolean[]`) that cuts memory by 8×?
