# Upper Bound in Java

This repository contains a Java implementation of the **Upper Bound** algorithm using Binary Search.  

---

## Problem Statement  

Given a **sorted integer array** `arr` and an integer `target`, return the **index** of the first element in `arr` that is strictly greater than `target`.  
If no such element exists, return `arr.length`.  

---

### Example  

**Input:**  
arr = [1, 2, 4, 4, 5], target = 2  

**Output:**  
2  

**Explanation:**  
- The first index where `arr[i] > 2` is `2`.  
- If all elements are less than or equal to `target`, the function will return `arr.length`.  

---

## Solution Approach  

This is a **binary search variant** that finds the **upper bound** of the target.  

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

- upperBound finds the first index where the element is strictly greater than the target.

- Often paired with lowerBound to count frequencies or define ranges in sorted arrays.