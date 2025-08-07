# Majority Element II in Java

This repository contains a Java implementation to find all **majority elements** in an integer array that appear more than **n/3 times**. The approach uses a **HashMap** to efficiently count the frequency of each number and returns those that exceed the threshold.

---

## Problem Statement

Given an integer array `nums` of size `n`, find all elements that appear more than **⌊ n / 3 ⌋ times**.

> **Note:** The algorithm should return a list of elements (up to 2 elements) that satisfy the condition.

---

### Example

**Input:**
```java
nums = [3, 2, 3]
```

**Output:**
```java
[3]
```

**Input:**
```java
nums = [1, 1, 1, 3, 3, 2, 2, 2]
```

**Output:**
```java
[1, 2]
```

## Solution Approach
The solution uses a HashMap to store frequencies of all elements in the array. After the frequencies are computed, it loops through the map and collects all keys whose count exceeds n / 3.

## Steps:
- Traverse the array and update frequency count using a HashMap<Integer, Integer>.

- Iterate over the map entries.

- If the frequency of a number is greater than n / 3, add it to the result list.

- Return the list.

## Java Implementation
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3)
                res.add(entry.getKey());
        }

        return res;
    }
}
```
## Time and Space Complexity
- Time Complexity: O(n)
- Each element is visited once to build the frequency map, and the map is then iterated once.

## Space Complexity: O(n)
In the worst case, all elements in the array are unique and stored in the map.

## Notes
- This approach is simple and easy to implement but uses additional space.

- A more optimized approach with O(1) space is possible using Boyer-Moore Voting Algorithm.

- The number of majority elements (appearing more than ⌊n/3⌋ times) can be at most 2.
