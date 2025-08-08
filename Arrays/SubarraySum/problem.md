# Subarray Sum Equals K in Java

This repository contains an efficient Java implementation for solving the **Subarray Sum Equals K** problem using a prefix sum and hashmap approach.

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return **the total number of subarrays** whose sum equals `k`.

---

### Example

**Input:**  
nums = [1, 2, 3], k = 3  

**Output:**  
2  

**Explanation:**  
The subarrays are:
- [1, 2] → sum is 3
- [3] → sum is 3

---

## Solution Approach

This solution uses the **prefix sum** concept with a **HashMap** to track the frequency of prefix sums encountered so far.

### Key Idea:
If `sum` is the current prefix sum at index `i`, and `sum - k` exists in the map, then all occurrences of `sum - k` correspond to subarrays ending at `i` with sum `k`.

---

### Steps:

1. Initialize a map with `{0: 1}` to handle cases where a subarray starting at index `0` sums to `k`.
2. Iterate over the array, updating the running prefix sum.
3. At each step, check if `(prefixSum - k)` exists in the map:
   - If yes, add its frequency to the count.
4. Update the map with the current prefix sum frequency.

---

## Java Implementation

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Handle subarrays starting from index 0

        int sum = 0, cnt = 0;
        for (int num : nums) {
            sum += num;
            int rem = sum - k;
            if (map.containsKey(rem)) {
                cnt += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
```

### Time and Space Complexity
- Time Complexity: `O(n)`
   Single pass through the array.

- Space Complexity: `O(n)`
   Extra space for storing prefix sum frequencies.

### Notes
- Works with negative numbers as well.

- The prefix sum + hashmap method ensures no nested loops are needed.