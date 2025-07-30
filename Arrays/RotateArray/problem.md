# Rotate Array

## Problem Statement
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### Example:
**Input:**  
`nums = [1, 2, 3, 4, 5, 6, 7], k = 3`  
**Output:**  
`[5, 6, 7, 1, 2, 3, 4]`

---

## Approach 1: Brute Force

### Idea:
- Rotate the array one step at a time, for `k` times.
- In each rotation, store the last element and shift every other element to the right.

### Code:
```java
class Solution {
    public void rotate(int[] nums, int k) {
       int n = nums.length;
       for (int i = 0; i < k; i++) {
           int temp = nums[n - 1];
           for (int j = n - 1; j > 0; j--) {
               nums[j] = nums[j - 1];
           }
           nums[0] = temp;
       }
    }
}
```
### Time Complexity
O(k * n) — For each of the k rotations, we traverse n elements.

### Space Complexity
O(1) — In-place rotation, no extra space used.

## Approach 2: Optimal — Reversal Algorithm
### Idea
Reverse the entire array.

Reverse the first k elements.

Reverse the remaining n-k elements.

### Important:
Before applying these operations, we must compute k = k % n to avoid unnecessary rotations or ArrayIndexOutOfBoundsException.

Code
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle large values of k

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

### Time Complexity
O(n) — Each reverse operation is linear.

### Space Complexity
O(1) — In-place reversal.

### Conclusion
The brute-force approach is intuitive but inefficient for large arrays or high k values.

The reversal algorithm is optimal and the preferred method in interviews.

Always remember to apply k = k % n to ensure correctness and efficiency.