# Lower Bound in Java

This repository contains a Java implementation of the **Lower Bound** algorithm using Binary Search.  

---

## Problem Statement  

Given a **sorted integer array** `arr` and an integer `target`, return the **index** of the first element in `arr` that is greater than or equal to `target`.  
If no such element exists, return `arr.length`.  

---

### Example  

**Input:**  
arr = [1, 2, 4, 4, 5], target = 4  

**Output:**  
2  

**Explanation:**  
- The first index where `arr[i] >= 4` is `2`.  
- If all elements are smaller than `target`, the function will return `arr.length`.  

---

## Solution Approach  

Binary search can be tweaked to find the **lower bound** instead of looking for an exact match.  

### Steps:  

1. Initialize two pointers: `l = 0`, `r = arr.length - 1`.  
2. While `l <= r`:  
   - Compute `mid = (l + r) / 2`.  
   - If `arr[mid] >= target`, update `res = mid` and move the right pointer left (`r = mid - 1`).  
   - Otherwise, move the left pointer right (`l = mid + 1`).  
3. Return `res`.  

---

## Java Implementation  

```java
class Solution {
    int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = arr.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] >= target){
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

- lowerBound finds the first index where the element is greater than or equal to the target.

- Related function: upperBound (first index where the element is strictly greater than the target).