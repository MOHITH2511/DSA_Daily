# Four Sum in Java

This repository contains a Java implementation to find all **unique quadruplets** in an array that sum up to a given target value.

---

## Problem Statement

Given an integer array `nums` and an integer `target`, return all **unique quadruplets** `[a, b, c, d]` such that:

`a + b + c + d == target`


You may return the answer in **any order**.

---

### Example

**Input:**  
nums = [1, 0, -1, 0, -2, 2]  
target = 0  

**Output:**  
[
  [-2, -1, 1, 2],  
  [-2, 0, 0, 2],  
  [-1, 0, 0, 1]  
]

### Explanation:
- After sorting the array, the algorithm fixes two numbers (`i` and `j`), then uses two pointers (`k` and `l`) to find pairs that complete the quadruplet.
- Duplicates are skipped to ensure each quadruplet is unique.

---

## Solution Approach

The solution uses a **two-pointer technique** after sorting:

1. **Sort the array** to make duplicate checking easier.
2. Use two nested loops (`i` and `j`) to fix the first two elements of the quadruplet.
3. Use two pointers (`k` and `l`) to find the other two numbers such that the sum equals `target`.
4. Skip duplicate values for all four indices to ensure uniqueness.
5. Collect all valid quadruplets into the result list.

---

## Java Implementation

```java
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates for j
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++; // skip duplicates for k
                        while (k < l && nums[l] == nums[l + 1]) l--; // skip duplicates for l
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}
```

### Time and Space Complexity
- Time Complexity: O(n³)
Sorting takes O(n log n) and the nested loops with two-pointer traversal take O(n³) in the worst case.

- Space Complexity: O(1) extra space (excluding the output list).
No additional data structures are used apart from the result storage.

### Notes
- Using long for sum avoids integer overflow when adding four large numbers.

- The array is sorted before processing, enabling efficient duplicate avoidance.

- Works for both positive and negative integers.

- Order of quadruplets in the result list does not matter.