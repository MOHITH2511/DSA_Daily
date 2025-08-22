# Search Insert Position in Java

This repository contains a Java implementation of the **Search Insert Position** algorithm using Binary Search.  

---

## Problem Statement  

Given a **sorted integer array** `nums` and an integer `target`, return the **index** if `target` is found.  
If not, return the index where it would be if it were inserted in order.  

---

### Example  

**Input:**  
nums = [1, 3, 5, 6], target = 5  

**Output:**  
2  

**Explanation:**  
- The element `5` exists in the array at index `2`.  
- If the target does not exist, the algorithm returns the position where it should be inserted to maintain the sorted order.  

---

## Solution Approach  

This problem is a direct variation of **binary search**.  
- Instead of returning `-1` when the element is not found, the function returns the index where the element should be inserted.  

### Steps:  

1. Initialize two pointers: `l = 0`, `r = nums.length`.  
2. While `l <= r`:  
   - Compute `mid = (l + r) / 2`.  
   - If `nums[mid] == target`, return `mid`.  
   - If `nums[mid] < target`, move left pointer to `mid + 1`.  
   - Otherwise, move right pointer to `mid - 1`.  
3. If not found, return `l`, which will be the correct insertion point.  

---

## Java Implementation  

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid < nums.length && nums[mid] == target) return mid;
            else if(mid < nums.length && nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
```

### Time and Space Complexity

- Time Complexity: O(log n)

- Space Complexity: O(1)

### Notes

- Works only on sorted arrays.

- This solution is a common variation of binary search, often used in problems involving *insertion points*.

- Related concepts: `lowerBound` and `upperBound.`