# Binary Search in Java

This repository contains a Java implementation of the **Binary Search** algorithm using both **iterative** and **recursive** approaches.  

---

## Problem Statement  

Given a **sorted integer array** `nums` and an integer `target`, return the **index** of `target` if it exists in `nums`. If it does not exist, return `-1`.  

---

### Example  

**Input:**  
nums = [-1, 0, 3, 5, 9, 12], target = 9  

**Output:**  
4  

**Explanation:**  
- The element `9` exists in the array at index `4`.  
- If the target does not exist, the function should return `-1`.  

---

## Solution Approach  

Binary Search works on **sorted arrays** by repeatedly dividing the search interval in half.  

### Steps:  

1. Start with two pointers: `left = 0` and `right = nums.length - 1`.  
2. Compute `mid = (left + right) / 2`.  
3. If `nums[mid] == target`, return `mid`.  
4. If `nums[mid] < target`, move the left pointer to `mid + 1`.  
5. Otherwise, move the right pointer to `mid - 1`.  
6. Repeat until `left > right`.  

This can be done both **iteratively** and **recursively**.  

---

## Java Implementations  

### Iterative Approach  

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (mid < nums.length && nums[mid] < target) left = mid + 1;
            else if (mid < nums.length) right = mid - 1;
        }
        return -1;
    }
}
```

### Recursive Approach
``` java
class Solution {
    public int search(int[] nums, int target) {
        return BinarySearch(nums, 0, nums.length - 1, target);
    }
    
    public int BinarySearch(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (mid < nums.length && nums[mid] == target) return mid;
        else if (mid < nums.length && nums[mid] < target) 
            return BinarySearch(nums, mid + 1, r, target);
        else 
            return BinarySearch(nums, l, mid - 1, target);
    }
}
```

### Time and Space Complexity

- Iterative Binary Search

     Time Complexity: O(log n)

     Space Complexity: O(1)

- Recursive Binary Search

     Time Complexity: O(log n)

     Space Complexity: O(log n) (due to recursive call stack)

### Notes

- Works only on sorted arrays.

- Iterative version is generally preferred for large arrays to avoid recursion depth limits.

- Both approaches guarantee logarithmic time efficiency.
