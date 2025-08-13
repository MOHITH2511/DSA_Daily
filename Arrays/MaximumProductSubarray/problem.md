# Maximum Product Subarray in Java

This repository contains two Java solutions for finding the **maximum product subarray** from a given integer array.

---

## Problem Statement

Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) that has the largest product, and return the product.

---

### Example

**Input:**  
nums = [2,3,-2,4]  

**Output:**  
6  

**Explanation:**  
- The subarray `[2,3]` has the largest product: `2 × 3 = 6`.

---

## Solution Approaches

### 1. Brute Force Approach

**Idea:**  
Check the product of every possible subarray and keep track of the maximum.

- Multiply elements for all subarrays.
- Update `max` whenever a higher product is found.
- Time complexity is **O(n²)**.

**Java Implementation:**
```java
class Solution {
    public int maxProduct(int[] nums) {
        int mul = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            mul = 1;
            for (int j = i; j < nums.length; j++) {
                mul *= nums[j];
                max = (mul > max) ? mul : max;
            }
        }
        return max;
    }
}
```

### 2. Optimized Dynamic Programming Approach
**Idea:**
Keep track of both the maximum and minimum product ending at each position, because a negative number can flip signs and turn a small product into a large one.

**Key steps:**

- Initialize curMax, curMin, and res as the first element.

- For each new number:

- If it's negative, swap curMax and curMin.

- Update curMax as the max of current number and curMax × number.

- Update curMin as the min of current number and curMin × number.

- Update the result.

**Java Implementation:**
``` java
class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(n, curMax * n);
            curMin = Math.min(n, curMin * n);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
```

### Time and Space Complexity
**Approach**	**Time Complexity**	**Space Complexity**
Brute Force	          O(n²)	                O(1)
Optimized DP	      O(n)	                O(1)

### Notes
- The brute force approach is easy to implement but slow for large inputs.

- The optimized DP approach leverages the fact that a negative value can turn a small product into a large one when multiplied by another negative.

- Works for arrays containing positive, negative, and zero values.
