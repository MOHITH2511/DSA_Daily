# Majority Element

## Problem Statement

Given an array `nums` of size `n`, find the majority element. The majority element is the element that appears more than `n / 2` times. You may assume that the majority element always exists in the array.

---

## Example

**Input:**  
`nums = [2, 2, 1, 1, 1, 2, 2]`  
**Output:**  
`2`

---

## Approach: Using HashMap

### Idea
- Traverse the array and store the frequency of each element in a `HashMap`.
- Iterate through the map entries and return the element whose frequency is more than `n / 2`.

### Code

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) res = entry.getKey();
        }

        return res;
    }
}
```

### Time and Space Complexity
Metric	            Value
Time Complexity	  - O(n)
Space Complexity  -	O(n)

## Optimized Approach: Boyer-Moore Voting Algorithm (O(1) space)
The most efficient solution to this problem is the Boyer-Moore Voting Algorithm, which runs in linear time and constant space.

### code

```java
public int findMajorityElement(int[] nums) {
        int count = 0, candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
```

### Time and Space Complexity
Metric	            Value
Time Complexity	 -  O(n)
Space Complexity -  O(1)

### Conclusion
The HashMap method is simple and intuitive.

Boyer-Moore Voting Algorithm is the optimal approach when space efficiency is required.