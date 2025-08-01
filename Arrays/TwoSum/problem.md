# Two Sum

## Problem Statement
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

---

### Example:
**Input:**  
`nums = [2, 7, 11, 15]`, `target = 9`  
**Output:**  
`[0, 1]`  
**Explanation:**  
Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

---

## Approach: Hash Map (Optimal)

### Idea:
- Iterate through the array.
- For each element, compute the complement (`target - current_element`).
- If the complement exists in the hash map, we found the pair.
- Otherwise, store the current element with its index in the map.

---

### Code:
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (map.containsKey(tar)) 
                return new int[]{map.get(tar), i};
            else 
                map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

### Time Complexity
O(n) — Single pass through the array, each lookup in the map is O(1).

### Space Complexity
O(n) — In the worst case, all n elements are stored in the hash map.

### Conclusion
This approach is highly efficient and widely used in interviews. It takes advantage of hash maps to achieve linear time complexity with optimal space usage.