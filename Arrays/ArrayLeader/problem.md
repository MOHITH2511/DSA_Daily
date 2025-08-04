# Array Leaders in Java

This repository contains an efficient Java implementation to find all **leaders** in a given array.

## Problem Statement

In an array, an element is called a **leader** if it is **greater than or equal to all elements to its right**. The **rightmost element is always a leader**.

### Example:

**Input** 
`[16, 17, 4, 3, 5, 2]`
**Output:** 
`[17, 5, 2]`


### Explanation:
- `2` → last element → leader  
- `5` > `2` → leader  
- `3`, `4` < `5` → not leaders  
- `17` > all elements to its right → leader  
- `16` < `17` → not a leader

---

## Solution Approach

- Traverse the array from **right to left**.
- Keep track of the **maximum value seen so far**.
- If the current element is **greater than or equal to** the max, it's a leader.
- Since leaders are collected in reverse order, reverse the result list at the end.

---

## Java Implementation

```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                res.add(max);
            }
        }

        Collections.reverse(res); // To return leaders in the original array order
        return res;
    }
}
```

### Time and Space Complexity
- **Time Complexity:** `O(n)` — Single pass from right to left.

- **Space Complexity:** `O(k)` — Where `k` is the number of leaders found.


### Notes
- This implementation includes elements that are equal to the current maximum (i.e., uses `>=`).

- If strict greater-than comparison is needed, replace `>=` with `>`.