You want to **sort an array according to the order of another array** in Java. This is a common problem when you have a “custom order” defined by a reference array. I’ll explain it step by step with an example.

---

### **Problem**

Suppose you have:

```java
int[] arr = {5, 3, 1, 9, 7, 3};
int[] order = {3, 1, 7};  // Custom order
```

You want to sort `arr` so that numbers in `order` appear first in the same order as `order`, and the remaining numbers follow in ascending order.
Expected result:

```
[3, 3, 1, 7, 5, 9]
```

---

### **Solution 1: Using `HashMap` to count occurrences**

```java
import java.util.*;

public class CustomSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 9, 7, 3};
        int[] order = {3, 1, 7};

        // Count occurrences of elements in arr
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // List to store result
        List<Integer> result = new ArrayList<>();

        // Add elements according to order array
        for (int num : order) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                for (int i = 0; i < count; i++) {
                    result.add(num);
                }
                countMap.remove(num);
            }
        }

        // Add remaining elements in ascending order
        List<Integer> remaining = new ArrayList<>(countMap.keySet());
        Collections.sort(remaining);
        for (int num : remaining) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
        }

        System.out.println(result);
    }
}
```

**Output:**

```
[3, 3, 1, 7, 5, 9]
```

---

### **Solution 2: Using `Comparator` (for `Integer[]`)**

If you can work with `Integer[]` instead of `int[]`, you can use a custom comparator:

```java
import java.util.*;

public class CustomSortComparator {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 1, 9, 7, 3};
        int[] order = {3, 1, 7};

        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            orderMap.put(order[i], i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (orderMap.containsKey(a) && orderMap.containsKey(b)) {
                return orderMap.get(a) - orderMap.get(b);
            } else if (orderMap.containsKey(a)) {
                return -1;
            } else if (orderMap.containsKey(b)) {
                return 1;
            } else {
                return a - b; // ascending for remaining
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
```

**Output:**

```
[3, 3, 1, 7, 5, 9]
```

---

### **Solution 3:  assign a priority to each element in the `order` array**

We **can assign a priority to each element in the `order` array** using a `HashMap` and a counter, even if the `order` array has duplicates. The trick is to make sure each occurrence gets a **priority based on its first occurrence or overall count**, depending on what behavior you want.

Let me break it down step by step.

---

### **Scenario**

```java
int[] arr = {5, 3, 1, 9, 7, 3, 3};
int[] order = {3, 1, 7, 3};  // note: duplicate 3
```

We want the elements in `arr` to be sorted **according to the first appearance in `order`** (taking duplicates into account), then remaining numbers in ascending order.

---

### **Step 1: Assign priority using HashMap**

```java
import java.util.*;

public class CustomSortWithPriority {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 1, 9, 7, 3, 3};
        int[] order = {3, 1, 7, 3};

        // Priority map
        Map<Integer, Integer> priorityMap = new HashMap<>();
        int priority = 0;

        for (int num : order) {
            // Only assign priority the first time it appears
            if (!priorityMap.containsKey(num)) {
                priorityMap.put(num, priority++);
            }
        }

        // Custom sort
        Arrays.sort(arr, (a, b) -> {
            if (priorityMap.containsKey(a) && priorityMap.containsKey(b)) {
                return priorityMap.get(a) - priorityMap.get(b);
            } else if (priorityMap.containsKey(a)) {
                return -1;
            } else if (priorityMap.containsKey(b)) {
                return 1;
            } else {
                return a - b; // ascending for remaining
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
```

**Output:**

```
[3, 3, 3, 1, 7, 5, 9]
```

---

### ✅ **Explanation**

1. **HashMap with counter**:
   Each unique element in `order` gets a priority starting from 0.
   
   * Duplicate entries in `order` are ignored for priority assignment.

2. **Custom Comparator**:
   
   * If both elements exist in `priorityMap`, compare by priority.
   * If only one exists, it comes first.
   * Remaining elements are sorted normally.

3. **Supports duplicates in both arrays**.

---

This approach is **efficient** and works for any type of input.

If you want, I can show an **even simpler approach that handles duplicates in the `order` array exactly as many times as they appear**, instead of ignoring duplicates, so the sort follows the *full repeated sequence of the order array*.

Do you want me to do that version?


