# Three Sum Problem

## Problem Statement
Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that:
- `i != j`
- `i != k`
- `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set must not contain duplicate triplets.

---

## Approach

### 1. Sort the array
We sort the input array in **O(n log n)** time. Sorting helps:
- Easily skip duplicate numbers to avoid duplicate triplets in the result.
- Use the two-pointer technique effectively.

### 2. Iterate with a fixed number
We iterate over the array with index `i` (from `0` to `n-3`):
- If `nums[i]` is the same as `nums[i-1]`, we skip to avoid duplicates.
- We then search for two other numbers such that their sum is `-nums[i]`.

### 3. Two-pointer search
We use two pointers:
- `left` starting from `i + 1`
- `right` starting from the end of the array

For each pair `(left, right)`:
- Calculate `sum = nums[i] + nums[left] + nums[right]`
- If `sum == 0`, we add it to the result and skip duplicates for both `left` and `right`.
- If `sum < 0`, we move `left` forward to increase the sum.
- If `sum > 0`, we move `right` backward to decrease the sum.

---

## Complexity Analysis
- **Time Complexity:** `O(n^2)`  
  Sorting takes `O(n log n)`, and for each element, the two-pointer search takes `O(n)`.
- **Space Complexity:** `O(1)` extra space (excluding the output list), since we sort the array in-place and use constant extra variables.

---

## Example

**Input:**
```text
nums = [-1, 0, 1, 2, -1, -4]
```

**Output:**
```text
[[-1, -1, 2], [-1, 0, 1]]
```


**Explanation:**
The triplets that sum to zero are:

`(-1, -1, 2)`

`(-1, 0, 1)`

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
```