# Upper Bound in Java

This repository contains a Java implementation of the **Upper Bound** algorithm using Binary Search.  

---

## Problem Statement  

Given a **sorted integer array** `arr` and an integer `target`, return the **index** of the first element in `arr` that is strictly greater than `target`.  
If no such element exists, return `arr.length`.  

---

### Example  

**Input:**  
arr = [1, 2, 4, 4, 5], target = 4  

**Output:**  
4  

**Explanation:**  
- The first index where `arr[i] > 4` is `4`.  
- If all elements are less than or equal to `target`, the function will return `arr.length`.  

---

## Solution Approach  

Binary search can be modified to find the **upper bound** instead of an exact match.  

### Steps:  

1. Initialize two pointers: `l = 0`, `r = arr.length - 1`.  
2. While `l <= r`:  
   - Compute `mid = (l + r) / 2`.  
   - If `arr[mid] > target`, update `res = mid` and move the right pointer left (`r = mid - 1`).  
   - Otherwise, move the left pointer right (`l = mid + 1`).  
3. Return `res`.  

---

## Java Implementation  

```java
class Solution {
    int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = arr.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] > target){
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
```

### Time and Space Complexity

- Time Complexity: O(log n)

- Space Complexity: O(1)

### Notes

- Works only on sorted arrays.

- `upperBound` is commonly used in problems involving frequency counts, ranges, and binary search based optimizations.

- Related function: `lowerBound` (first index where `arr[i] >= target`).