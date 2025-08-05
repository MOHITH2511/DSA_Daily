# Longest Consecutive Sequence

## Problem Statement
Write a function to find the length of the longest consecutive elements sequence in an unsorted integer array.

A consecutive sequence means numbers that appear in increasing order by 1, not necessarily adjacent in the array.

This is based on the LeetCode problem:  
🔗 [LeetCode 128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/)

## Example
**Input:** [100, 4, 200, 1, 3, 2]  
**Output:** 4  
**Explanation:** The longest consecutive sequence is [1, 2, 3, 4].

## Approach
- Use a `HashSet` to store all elements from the array for quick lookups.
- Iterate through the set:
  - If `num - 1` is not in the set, the current number could be the start of a sequence.
  - Use a `while` loop to count the length of the sequence starting from that number.
  - Keep track of the longest sequence found.
- Return the maximum sequence length found.

## Code
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
```

## Time Complexity
- **O(n)** — Each number is processed at most twice: once when inserted into the set, and once when checking for sequence.

## Space Complexity
- **O(n)** — A `HashSet` is used to store the unique elements from the input array.