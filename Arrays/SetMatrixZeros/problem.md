# Set Matrix Zeroes in Java

This repository contains an efficient Java implementation for solving the **Set Matrix Zeroes** problem using additional space to track zeroes in the matrix.

---

## Problem Statement

Given an `m x n` matrix, if an element is **0**, set its **entire row and column** to `0`. The operation must be done **in-place** (modifying the original matrix).

---

### Example

**Input:**  
[[1, 1, 1],
[1, 0, 1],
[1, 1, 1]]


**Output:**  
[[1, 0, 1],
[0, 0, 0],
[1, 0, 1]]


### Explanation:
- The element at position `(1, 1)` is `0`.
- So, row `1` and column `1` are set to zero in the final matrix.

---

## Solution Approach

This solution uses **extra space** to track which rows and columns need to be zeroed out.

### Steps:

1. Traverse the matrix once and **mark rows and columns** that contain a `0` using two boolean arrays.
2. Traverse the matrix again, and set the element at position `(i, j)` to `0` if either `row[i]` or `col[j]` is marked as `true`.

---

## Java Implementation

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // Mark the rows and columns that need to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Zero out marked rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```

### Time and Space Complexity
- Time Complexity: `O(m * n)`
Full traversal of the matrix in two passes.

- Space Complexity: `O(m + n)`
Additional space for row and column boolean arrays.

### Notes
- This approach is not constant space, but it's simple and avoids modifying the matrix while scanning.

- A more advanced solution can achieve O(1) space by using the first row and column as markers.

