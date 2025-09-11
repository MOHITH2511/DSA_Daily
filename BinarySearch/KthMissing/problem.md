# K-th Missing Positive Number – Java Solution  

This repository contains a Java implementation of the **K-th Missing Positive Number** problem using **Binary Search**.  

---

## Problem Statement  

Given a sorted array of positive integers `arr` and an integer `k`, return the **k-th positive integer** that is missing from the array.  

---

### Example  

**Input:**  
arr = [2, 3, 4, 7, 11], k = 5  

**Output:**  
9  

**Explanation:**  
- Missing numbers are [1, 5, 6, 8, 9, 10, …]  
- The 5th missing number is 9.  

---

## Solution Approach  

This problem can be solved efficiently using **Binary Search**:  

1. At index `i`, the number of missing integers before `arr[i]` is: missing = arr[i] - (i + 1)
2. Perform binary search to find the first index where `missing >= k`.  
3. After the search, the answer will be `left + k`, where `left` is the position found by binary search.  

---

## Java Implementation  

```java
class Solution {
 public int findKthPositive(int[] arr, int k) {
     int left = 0, right = arr.length - 1;
     while (left <= right) {
         int mid = left + (right - left) / 2;
         int missing = arr[mid] - (mid + 1);
         if (missing < k) {
             left = mid + 1;
         } else {
             right = mid - 1;
         }
     }
     return left + k;
 }
}
```

### Time and Space Complexity
#### Time Complexity:

- Binary search runs in O(log n)

- Each step does constant work.

- Overall: `O(log n)`

#### Space Complexity:

- Only a few extra variables are used → `O(1)`

#### Notes

- A naive solution would check missing numbers one by one in `O(n)`.

- The binary search approach leverages the sorted property for efficiency.

- This works well even for large arrays and large `k`.