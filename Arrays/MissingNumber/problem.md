
# Missing Number in an Array

## Problem Statement
You are given an array of `n` distinct integers in the range from `1` to `n+1`. One number in this range is missing. Your task is to find the missing number.

---

## Example

**Input:**  
`arr = [1, 2, 4, 5]`

**Output:**  
`3`

**Explanation:**  
The numbers from `1` to `5` are expected. `3` is missing.

---

## Approach (Efficient using Sum Formula)

1. The sum of first `n+1` natural numbers is calculated using the formula:  
   \[
   \text{Total} = \frac{(n+1) \times (n+2)}{2}
   \]
2. Calculate the sum of the array elements.
3. The missing number is `Total - Sum`.

---

## Code

```java
class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;
        int total = (n + 1) * (n + 2) / 2; // Sum of first n+1 natural numbers
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return total - sum;
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 4, 5};
        System.out.println("Missing number: " + sol.missingNum(arr)); // Output: 3
    }
}
```

---

## Time & Space Complexity

- **Time Complexity:** `O(n)` — Single pass through the array.
- **Space Complexity:** `O(1)` — Constant extra space used.
