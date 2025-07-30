# Move Zeroes – Leetcode Problem

## Problem Statement

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

You must do this in-place without making a copy of the array.

---

## Efficient Approach: Two Pointer Method

### Idea:

- Use a pointer `index` to track the position of the next non-zero element.
- First pass: Iterate through the array and move all non-zero elements to the front.
- Second pass: From `index` to the end of the array, fill the remaining positions with `0`.

---

## Code (Java)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++; 
            }
            }
        while(index<nums.length)
            nums[index++] = 0;
        }
    }
```

### Time Complexity
O(n) – One pass to move non-zero elements + one pass to insert zeros.

### Space Complexity
O(1) – In-place operation with constant space.

### Key Insights
Avoid nested loops or shifting elements every time a 0 is found (which leads to O(n^2)).

Using a write pointer (index) ensures we only touch each element at most twice — once when writing non-zeros and once when filling with zeros.

This method is efficient and clean for interview settings.

### Conclusion
This two-pass, in-place approach is optimal for moving zeroes in an array.

Simple pointer manipulation leads to readable and efficient code.