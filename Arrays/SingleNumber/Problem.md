# Single Number

## Problem Statement
Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement a solution with **linear runtime complexity** and **constant space**.

### Example:
**Input:**  
`nums = [4, 1, 2, 1, 2]`  
**Output:**  
`4`

---

## Approach: Bit Manipulation (XOR)

### Idea:
- XOR has two important properties:
  - `a ^ a = 0`
  - `a ^ 0 = a`
- If you XOR all elements together, the pairs will cancel out (`x ^ x = 0`) and only the single number will remain.

### Code:
```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
```

### Time Complexity
O(n) — We iterate through the array once.

### Space Complexity
O(1) — Constant extra space used.

### Conclusion
This approach is optimal in both time and space complexity. It smartly uses the XOR operation to cancel out repeated elements and find the unique one.