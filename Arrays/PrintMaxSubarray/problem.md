# Maximum Subarray Sum — Kadane's Algorithm

## Problem Statement

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return that subarray.

### Example

**Input:**  
`nums = [-2,1,-3,4,-1,2,1,-5,4]`  
**Output:**  
`[4, -1, 2, 1]`  
**Explanation:** The maximum sum subarray is `[4, -1, 2, 1]` with a sum of 6.

---

## Approach: Kadane's Algorithm

### Intuition:
Kadane's Algorithm is a **Dynamic Programming** approach that efficiently finds the maximum sum of a contiguous subarray in linear time.  
It works by scanning through the array while keeping track of the **current subarray sum** and **maximum sum** encountered so far.

---

### Key Steps:

- Initialize `currentSum = 0` and `maxSum = Integer.MIN_VALUE`.
- Iterate through the array:
  - Add current element to `currentSum`.
  - If `currentSum > maxSum`, update `maxSum` and record subarray indices.
  - If `currentSum < 0`, reset `currentSum = 0` and update the starting point.
- Print the subarray from `start` to `end`.

---

## Java Code

```java
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    public static void maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0, start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
```

### Time & Space Complexity
- Time Complexity: O(n) — Single pass through the array.

- Space Complexity: O(1) — Constant extra space.

### Notes
- This is one of the most popular problems in dynamic programming.

- Kadane's Algorithm can also be extended to return just the sum, or the actual subarray as done above.

- The core trick is resetting the current sum when it becomes negative.