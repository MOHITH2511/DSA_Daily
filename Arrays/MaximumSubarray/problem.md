# Kadane's Algorithm - Maximum Subarray Sum

This project implements **Kadane’s Algorithm** to find the **maximum sum of a contiguous subarray** in a given integer array.

---

## Problem Statement

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

---

## Approach: Kadane’s Algorithm

### Idea:
We iterate through the array and, at each index, we either:
- **Extend the previous subarray**, or
- **Start a new subarray** from the current index

This decision is based on whether the running sum (`currentSum`) is negative or not.

---

### Algorithm Steps

1. Initialize `maxSum` to the smallest integer and `currentSum` to 0.
2. Traverse the array:
   - Add the current element to `currentSum`
   - Update `maxSum` as the maximum of itself and `currentSum`
   - If `currentSum` becomes negative, reset it to 0
3. Return `maxSum`

---

## Example

```text
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: [4, -1, 2, 1] has the largest sum = 6
```

### Code:
``` java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0)
                currentSum = 0;
        }

        return maxSum;
    }
}
```

### Time and Space Complexity
Time Complexity: O(n) — Single pass through the array

Space Complexity: O(1) — Constant extra space

---

### Key Notes
- Efficient and optimal for contiguous subarrays

- Works well even with negative numbers

- Handles edge cases like all negative elements
