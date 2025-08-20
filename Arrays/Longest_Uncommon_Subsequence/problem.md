# Longest Uncommon Subsequence I

This is the solution for **LeetCode Problem 521: Longest Uncommon Subsequence I**.

## Problem Description
Given two strings `a` and `b`, return the length of the **longest uncommon subsequence** between them.  
An uncommon subsequence is a string that is a subsequence of exactly one of the two given strings.  
If no such subsequence exists, return `-1`.

### Examples
Input: a = "aba", b = "cdc"
Output: 3
Explanation: "aba" is a subsequence of a but not of b.


### Constraints
- 1 <= a.length, b.length <= 100  
- `a` and `b` consist of lowercase English letters  

---

## Approach
This problem looks like it requires subsequence checking, but it reduces to a much simpler case:

1. If `a` and `b` are **equal**, then every subsequence of `a` is also a subsequence of `b`.  
   → Answer = `-1`.

2. If `a` and `b` are **different**, then the longer string itself is an uncommon subsequence, since it cannot be a subsequence of the other.  
   → Answer = `max(a.length, b.length)`.

This makes the problem solvable in **O(1) time**.

---

## Java Solution
```java
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
```

### Complexity Analysis

- Time Complexity: O(1) – just a comparison and a length check.

- Space Complexity: O(1) – no extra space used.