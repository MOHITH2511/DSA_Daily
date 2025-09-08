# Single Element in a Sorted Array

This repository contains a Java implementation of finding the **single non-duplicate element** in a sorted array using **Binary Search**.  

---

## Problem Statement  

Given a **sorted integer array** `nums` where every element appears **exactly twice** except for one element that appears only once, return the single element.  

The solution must run in **O(log n)** time and use **O(1)** space.  

---

### Example  

**Input:**  
nums = [1,1,2,3,3,4,4,8,8]  

**Output:**  
2  

**Explanation:**  
- Every element occurs twice except `2`.  
- The array is sorted, which allows binary search to efficiently find the unique element.  

---

## Solution Approach  

We use a modified **binary search** to locate the unique element.  

### Steps:  

1. Handle base cases:  
   - If the array length is 1, return that element.  
   - If the first element differs from the second, return the first.  
   - If the last element differs from the second last, return the last.  

2. Perform binary search between indices `1` and `n-2`:  
   - Check if `nums[mid]` is different from both neighbors → if true, return it.  
   - Otherwise, use index parity (even/odd) to decide which side of the array contains the single element:  
     - If `mid` is even and equals the next element, search **right half**.  
     - If `mid` is odd and equals the previous element, search **right half**.  
     - Otherwise, search **left half**.  

3. Return the found element.  

---

## Java Implementation  

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        int n = nums.length;
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n - 2;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            if((mid % 2 == 1 && nums[mid-1] == nums[mid]) || 
               (mid % 2 == 0 && nums[mid] == nums[mid+1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
```

### Time and Space Complexity

- Time Complexity: O(log n) (binary search).

- Space Complexity: O(1) (constant extra space).

### Notes

- This works because in a sorted array, pairs align at even/odd indices before the single element.

- After the single element, this pairing shifts, which is the key observation enabling binary search.

- Related problems: Find the first/last occurrence of an element, Lower Bound, Upper Bound.