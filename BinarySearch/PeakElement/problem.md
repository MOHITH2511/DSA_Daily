# Find Peak Element

This repository contains a Java implementation of finding a **peak element** in an array using two approaches:  

1. **Linear Scan (O(n))**  
2. **Binary Search (O(log n))**  

---

## Problem Statement  

A **peak element** in an integer array is an element that is **strictly greater than its neighbors**.  
- Given an array `nums`, return the index of **any one peak element**.  
- You may assume that `nums[-1] = -∞` and `nums[n] = -∞`, where `n` is the length of the array.  
- The solution should ideally run in **O(log n)** time.  

---

### Example  

**Input:**  
nums = [1,2,3,1]

**Output:**  
2

**Explanation:**  
- `nums[2] = 3` is a peak element because it is greater than both neighbors (`2` and `1`).  

---

## Solution Approaches  

### 1. Linear Scan  

We simply check:  
- If the first element is greater than the second, return index `0`.  
- If the last element is greater than the second last, return `n-1`.  
- Otherwise, scan the array and return the index where `nums[i] > nums[i-1] && nums[i] > nums[i+1]`.  

#### Java Implementation  

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int res = 0;
        int n = nums.length;
        if(n >= 2 && nums[0] > nums[1]) return 0;
        else if(n >= 2 && nums[n-1] > nums[n-2]) return n-1;

        for(int i = 1; i < n-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) res = i;
        }
        return res;
    }
}
```
### Complexity
### Time Complexity: O(n) (linear scan through the array).

### Space Complexity: O(1).

### 2. Binary Search
We use a binary search strategy:

If nums[mid] > nums[mid+1], then a peak lies on the left side (including mid).

Otherwise, the peak lies on the right side.

This guarantees convergence to a peak in logarithmic time.

#### Java Implementation
``` java
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid+1]) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
```
### Complexity
### Time Complexity: O(log n) (binary search).

### Space Complexity: O(1).

### Notes
- Multiple peaks can exist; any valid peak index is acceptable.

- Binary search is the optimal approach for large arrays.

- Related problems: "Single Element in a Sorted Array", "Find Minimum in Rotated Sorted Array".