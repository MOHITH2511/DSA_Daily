# Spiral Matrix in Java

This repository contains a Java implementation for printing a **2D matrix in spiral order**. The traversal is done **in-place**, using boundary pointers.

---

## Problem Statement

Given an `m x n` matrix, return all elements of the matrix in **spiral order** starting from the top-left corner and moving clockwise.

---

### Example

**Input:**  
[[1, 2, 3],  
 [4, 5, 6],  
 [7, 8, 9]]  

**Output:**  
[1, 2, 3, 6, 9, 8, 7, 4, 5]

### Explanation:
- The elements are traversed in the following order:
  - Top row → Right column → Bottom row (in reverse) → Left column (in reverse)
  - Then move inward and repeat.

---

## Solution Approach

The matrix is traversed using four boundary pointers:

- `top` — initially `0`
- `bottom` — initially `rows - 1`
- `left` — initially `0`
- `right` — initially `cols - 1`

### Steps:

1. Traverse from **left to right** across the top row.
2. Traverse from **top to bottom** along the right column.
3. Traverse from **right to left** across the bottom row.
4. Traverse from **bottom to top** along the left column.
5. Move the boundaries inward and repeat until all elements are covered.

---

## Java Implementation

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int top = 0, bottom = row - 1, right = col - 1, left = 0;
        int count = 0;
        List<Integer> li = new ArrayList<>();

        while (left <= right || top <= bottom) {
            if (count == row * col) break;

            for (int i = left; i <= right; i++) {
                li.add(matrix[top][i]);
                count++;
            }
            top++;
            if (count == row * col) break;

            for (int i = top; i <= bottom; i++) {
                li.add(matrix[i][right]);
                count++;
            }
            right--;
            if (count == row * col) break;

            for (int i = right; i >= left; i--) {
                li.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            if (count == row * col) break;

            for (int i = bottom; i >= top; i--) {
                li.add(matrix[i][left]);
                count++;
            }
            left++;
            if (count == row * col) break;
        }

        return li;
    }
}
```

### Time and Space Complexity
- Time Complexity: O(m * n)
Every element in the matrix is visited once.

- Space Complexity: O(1) (excluding output list)
No additional space is used apart from the result list.

### Notes
- This solution works for both square and rectangular matrices.

- Boundary checks and count tracking are crucial to prevent redundant traversals or index errors.

- Can be extended to print elements in spiral order instead of returning the list.

