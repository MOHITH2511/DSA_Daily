# Find Max Consecutive Ones

## Problem Statement
Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

### Example:
**Input:**  
`nums = [1, 1, 0, 1, 1, 1]`  
**Output:**  
`3`

---

## Approach: Linear Scan

### Idea:
- Traverse the array and count the number of consecutive 1s.
- If a `0` is encountered, update the `max` if needed and reset the current count.
- At the end, compare once more to capture any final run of 1s.

---

### Code:
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for (int ele : nums) {
            if (ele == 0) {
                max = Math.max(max, curr);
                curr = 0;
            } else {
                curr++;
            }
        }
        max = Math.max(max, curr);
        return max;
    }
}
```

### Time Complexity
O(n) — Single pass through the array.

### Space Complexity
O(1) — Constant extra space.

### Conclusion
This approach efficiently computes the longest streak of 1s in a binary array using a simple linear scan and is optimal in both time and space.