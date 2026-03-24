This makes it crystal clear why `&&` is dangerous in two-pointer loops.

⚠️ **Common While-Loop Pointer Mistake**

**Mistake:**

```java
while (i < n && j < n) { ... }
```

* Using `&&` when controlling two pointers can **stop the loop too early**.
* As soon as `j` (or `i`) reaches the end, the loop ends, and you **won’t be able to finish the work of the other pointer**.
