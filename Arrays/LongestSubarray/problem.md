# Longest Subarray Sum Equals K in Java

This repository contains a Java implementation for finding the **length of the longest subarray** whose sum equals a given integer `k`, using the prefix sum technique with a hashmap.

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return the **length of the longest subarray** whose sum equals `k`.

---

### Example

**Input:**  
nums = [1, -1, 5, -2, 3], k = 3  

**Output:**  
4  

**Explanation:**  
- The subarray `[1, -1, 5, -2]` has a sum of `3` and length `4`.  
- No longer subarray exists with sum `3`.

---

## Solution Approach

This solution uses the **prefix sum** technique and a **hashmap** to track the first index where each prefix sum occurs.

### Steps:

1. Keep a running sum (`sum`) as you iterate through the array.
2. If `sum == k`, update `len` to `i + 1` since the subarray starts from index 0.
3. Compute `rem = sum - k`.  
   - If `rem` exists in the map, it means there is a previous prefix sum that can form a subarray ending at the current index with sum `k`.  
   - Update `len` to the maximum length found.
4. Store the first occurrence of each `sum` in the map (do not overwrite existing entries, since we want the earliest index for maximum length).

---

## Java Implementation

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) len = Math.max(len, i + 1);

            int rem = sum - k;
            if (map.containsKey(rem)) {
                len = Math.max(len, i - map.get(rem));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
```

### Time and Space Complexity
- Time Complexity: O(n)
   Single traversal of the array.

- Space Complexity: O(n)
   HashMap to store prefix sums and their first occurrence indices.

### Notes
- Works with positive, negative, and zero integers in the array.
- Using the earliest index for each prefix sum ensures maximum possible subarray length.
