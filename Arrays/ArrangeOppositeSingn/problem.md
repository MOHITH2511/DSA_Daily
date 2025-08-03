# Rearrange Array Elements by Sign

## Problem Statement

You are given a **0-indexed** integer array `nums` of **even length** consisting of an equal number of **positive** and **negative** integers.

You need to rearrange the elements of `nums` such that the rearranged array satisfies the following conditions:

- Every **even index** has a **positive** number.
- Every **odd index** has a **negative** number.

Return the resulting array.

---

## Example

**Input:**  
`nums = [3, 1, -2, -5, 2, -4]`

**Output:**  
`[3, -2, 1, -5, 2, -4]`

**Explanation:**  
Positive numbers are placed at even indices (0, 2, 4), and negative numbers are placed at odd indices (1, 3, 5).

---

## Approach

We use two pointers:

- `pos` for tracking the next even index to place a positive number.
- `neg` for tracking the next odd index to place a negative number.

We iterate through the original array once and place each element in its correct position in the result array.

---

## Java Code

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[pos] = nums[i];
                pos += 2;
            } else {
                res[neg] = nums[i];
                neg += 2;
            }
        }

        return res;
    }
}
```

### Time and Space Complexity
- Time Complexity: O(n) — One full pass through the input array.

- Space Complexity: O(n) — A separate result array is used to store rearranged elements.

### Notes
- This approach guarantees that positive and negative numbers alternate starting with a positive number at index `0`.

- Works only when the number of positive and negative integers are equal and array length is even, as per constraints.

