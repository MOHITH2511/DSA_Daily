# Next Permutation

## Problem Statement

Implement the next lexicographically greater permutation of an integer array. If such an arrangement is not possible (i.e., the array is in descending order), rearrange it as the lowest possible order (i.e., sorted in ascending order).

You must do this **in-place** with only constant extra memory.

---

## Example

**Input:**  
`nums = [1, 2, 3]`  
**Output:**  
`[1, 3, 2]`

**Input:**  
`nums = [3, 2, 1]`  
**Output:**  
`[1, 2, 3]`

---

## Approach

This problem can be solved using a 3-step process:

1. **Find the breakpoint:**
   - Traverse from the right and find the first index `i` such that `nums[i] < nums[i + 1]`.
   - If no such index exists, it means the array is in descending order. Reverse the whole array and return.

2. **Find the next greater element:**
   - Again, traverse from the right and find the first index `j` such that `nums[j] > nums[i]`. Swap `nums[i]` and `nums[j]`.

3. **Reverse the subarray after the breakpoint:**
   - Reverse the portion of the array from `i + 1` to the end to get the next permutation in lexicographical order.

📘 **Recommended Reading:**  
For a detailed explanation and visual walkthrough, refer to this helpful article:  
🔗 [Next Permutation - Take U Forward](https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/)

---

## Java Code

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1, n = nums.length;

        // Step 1: Find the breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no breakpoint found, reverse the entire array
        if (ind == -1) {
            reverse(0, n - 1, nums);
            return;
        }

        // Step 2: Find the next greater element from the end
        for (int i = n - 1; i > ind; i--) {
            if (nums[ind] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        // Step 3: Reverse the suffix
        reverse(ind + 1, n - 1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

### Time and Space Complexity
- Time Complexity: O(n) — We traverse the array at most 3 times.

- Space Complexity: O(1) — In-place manipulation, no extra memory used.

### Key Takeaways
- Efficient algorithm that doesn't require generating all permutations.

- Works in-place, no auxiliary data structures needed.

- Common interview problem that tests understanding of permutations and array manipulation.
