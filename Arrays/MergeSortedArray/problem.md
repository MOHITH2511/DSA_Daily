# Merge Sorted Arrays in Java

This repository contains a Java implementation to **merge two sorted arrays** into one sorted array.

---

## Problem Statement

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

- `nums1` has a length of `m + n`, where the first `m` elements are valid and the last `n` elements are set to `0` and should be ignored.
- Merge `nums2` into `nums1` so that `nums1` becomes a single sorted array.

---

### Example

**Input:**  
nums1 = [1,2,3,0,0,0], m = 3  
nums2 = [2,5,6], n = 3  

**Output:**  
[1,2,2,3,5,6]  

**Explanation:**  
- The first `m` elements of `nums1` are `[1,2,3]`.  
- `nums2` is `[2,5,6]`.  
- After merging and sorting, `nums1` becomes `[1,2,2,3,5,6]`.

---

## Solution Approach

This solution uses the following steps:

1. Start inserting elements from `nums2` into the unused portion of `nums1` (from index `m` onwards).
2. Use **`Arrays.sort()`** to sort the combined array in non-decreasing order.
3. This modifies `nums1` in place.

---

## Java Implementation

```java
import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[index++];
        }
        Arrays.sort(nums1);
    }
}
```

### Time and Space Complexity
- Time Complexity: `O((m + n) log(m + n))`
  Sorting the final array of size `m + n` takes `O((m + n) log(m + n))`.

- Space Complexity: `O(1)`
  The merge is done in place without extra storage.

---

### Notes
- This approach is simple but not the most optimal.
- An `O(m + n)` solution exists using three pointers to merge from the end without sorting.
- Works for both positive and negative numbers.
- Assumes `nums1` has enough space to hold elements of `nums2`.