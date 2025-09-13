# Smallest Divisor Given a Threshold – Java Solution  

This repository contains a Java implementation of the **Smallest Divisor Given a Threshold** problem using **Binary Search on Answer**.  

---

## Problem Statement  

You are given an integer array `nums` and an integer `threshold`.  

- You need to choose a **positive integer divisor**.  
- For each element in `nums`, divide it by the divisor and round up (ceiling division).  
- Sum up these values.  

Return the **smallest divisor** such that the sum is **less than or equal to** `threshold`.  

---

### Examples  

**Example 1:**  

**Input:**  
nums = [1,2,5,9], threshold = 6  

**Output:**  
5  

**Explanation:**  
- Divisor = 5 → ceil(1/5) + ceil(2/5) + ceil(5/5) + ceil(9/5) = 1 + 1 + 1 + 2 = 5 ≤ 6 ✅  
- Any smaller divisor gives a sum > 6.  

---

**Example 2:**  

**Input:**  
nums = [44,22,33,11,1], threshold = 5  

**Output:**  
44  

**Explanation:**  
- Divisor = 44 → ceil(44/44)+ceil(22/44)+ceil(33/44)+ceil(11/44)+ceil(1/44)  
= 1+1+1+1+1 = 5 ≤ 5 

---

**Example 3:**  

**Input:**  
nums = [2,3,5,7,11], threshold = 11  

**Output:**  
3  

**Explanation:**  
- Divisor = 3 → ceil(2/3)+ceil(3/3)+ceil(5/3)+ceil(7/3)+ceil(11/3)  
= 1+1+2+3+4 = 11 ≤ 11

---

## Solution Approach  

This is a **Binary Search on Answer** problem:  

1. The smallest possible divisor is `1`.  
2. The largest possible divisor is `max(nums)`.  
3. Use binary search to minimize the divisor:  
   - Compute the sum of `ceil(num / divisor)` for all elements.  
   - If the sum ≤ threshold, try a smaller divisor (`high = mid`).  
   - Otherwise, increase the divisor (`low = mid + 1`).  
4. When `low == high`, that’s the smallest valid divisor.  

---

## Java Implementation  

```java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int low = 1, high = max;
        while (low < high) {
            int mid = (low + high) / 2;
            if (possible(nums, threshold, mid)) {
                high = mid; // try smaller divisor
            } else {
                low = mid + 1; // need bigger divisor
            }
        }
        return low;
    }

    public boolean possible(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / (double) divisor);
            if (sum > threshold) return false; // early stop
        }
        return true;
    }
}
```

### Time and Space Complexity
#### Time Complexity:

- Checking feasibility takes `O(n)`.

- Binary search runs in `O(log(max(nums)))`.

- Overall: `O(n log(max(nums)))`.

#### Space Complexity:

- Only a few extra variables are used → `O(1)`.

### Notes

- This is a classic binary search on the answer problem.

- Using integer math (num + divisor - 1) / divisor instead of Math.ceil avoids floating-point overhead.

- Efficient for large inputs where `nums[i]` can be as large as 10^6.