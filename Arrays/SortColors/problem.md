# Sort Colors

## Problem Statement
Given an array `nums` with `n` objects colored red, white, or blue (represented by `0`, `1`, and `2`), sort them in-place so that objects of the same color are adjacent, with the colors in the order red (0), white (1), and blue (2).

You must solve this problem **without using the library's sort function**.

---

### Example:
**Input:**  
`nums = [2, 0, 2, 1, 1, 0]`  
**Output:**  
`[0, 0, 1, 1, 2, 2]`

---

## Approach: Counting Sort

### Idea:
- Count the number of 0s, 1s, and 2s.
- Then overwrite the array by filling in the counted number of 0s, then 1s, and then 2s.

---

### Code:
```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, i = 0;
        int zc = 0, oc = 0, tc = 0; // Counters for 0s, 1s, and 2s
        
        // First pass: Count occurrences
        while(i < n){
            if(nums[i] == 0) zc++;
            else if(nums[i] == 1) oc++;
            else if(nums[i] == 2) tc++;
            i++;
        }

        // Second pass: Overwrite array
        i = 0;
        while(i < n){
            if(zc != 0) {
                nums[i] = 0;
                zc--;
            } else if(oc != 0){
                nums[i] = 1;
                oc--;
            } else if(tc != 0){
                nums[i] = 2;
                tc--;
            }
            i++;
        }
    }
}
```

### Time Complexity
O(n) — Two passes through the array of n elements.

### Space Complexity
O(1) — Only a few integer variables are used, so the space usage is constant.

### Conclusion
This is a simple and efficient counting sort-based approach that satisfies the in-place requirement with constant space. For interview scenarios, this is clear, easy to implement, and performs well.

For further optimization, the Dutch National Flag algorithm can sort the array in a single pass with constant space.
