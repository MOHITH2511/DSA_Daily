# Find First and Last Position of Element in Sorted Array (Binary Search in Java)

This repository contains a Java implementation of solving the **"Find First and Last Position of Element in Sorted Array"** problem using **Binary Search**.  

---

## Problem Statement  

Given a **sorted integer array** `nums` and an integer `target`, return the **starting** and **ending** position of `target` in the array.  

If `target` is not found, return `[-1, -1]`.  

---

### Example  

**Input:**  
nums = [5, 7, 7, 8, 8, 10], target = 8  

**Output:**  
[3, 4]  

**Explanation:**  
- The element `8` first appears at index `3` and last appears at index `4`.  
- If the target is not present, the function should return `[-1, -1]`.  

---

## Solution Approach  

This solution uses **binary search twice**:  
1. Once to find the **first occurrence** of the target.  
2. Once to find the **last occurrence** of the target.  

Both searches run in `O(log n)` time, making the whole algorithm efficient for large arrays.  

---

### Steps  

1. Use binary search to find the **leftmost index** (`Findex`) where `target` appears.  
   - If `nums[mid] == target`, shift `right` pointer left to keep searching for earlier occurrences.  

2. Use binary search again to find the **rightmost index** (`Lindex`) where `target` appears.  
   - If `nums[mid] == target`, shift `left` pointer right to keep searching for later occurrences.  

3. Return `[Findex, Lindex]`.  
   - If the target does not exist, both will remain `-1`.  

---

## Java Implementation  

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int Findex = -1;
        int l = 0, r = nums.length;
        
        // Find first occurrence
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid < nums.length && nums[mid] == target){
                Findex = mid;
                r = mid - 1;
            } else if(mid < nums.length && nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        int Lindex = -1;
        l = 0;
        r = nums.length;
        
        // Find last occurrence
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid < nums.length && nums[mid] == target){
                Lindex = mid;
                l = mid + 1;
            } else if(mid < nums.length && nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        res[0] = Findex;
        res[1] = Lindex;
        return res;
    }
}
```

### Time and Space Complexity

- Time Complexity: O(log n) (two binary searches).

- Space Complexity: O(1) (no extra space used apart from variables).

### Notes

- Works only on sorted arrays.

- If the target element appears only once, both first and last indices will be the same.

- If the target element does not appear, both indices will be -1.

- This approach avoids linear scanning and guarantees logarithmic time.