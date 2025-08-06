# Rotate Image in Java

This repository contains an efficient Java implementation for solving the **Rotate Image** problem by rotating a square matrix **90 degrees clockwise in-place**.

---

## Problem Statement

You are given an `n x n` 2D matrix representing an image. Rotate the image by **90 degrees (clockwise)**.  
You must **rotate the matrix in-place**, modifying the input matrix directly without using extra memory for another matrix.

---

### Example

**Input:**  
[[1, 2, 3],  
 [4, 5, 6],  
 [7, 8, 9]]  

**Output:**  
[[7, 4, 1],  
 [8, 5, 2],  
 [9, 6, 3]]  

### Explanation:
- The matrix is first **transposed** by swapping elements across its main diagonal.
- Then, each row is **reversed** to complete the 90-degree clockwise rotation.

---

## Solution Approach

The rotation is performed in two steps:

1. **Transpose the matrix**  
   Swap element at `(i, j)` with `(j, i)` for all `i < j`.

2. **Reverse each row**  
   After transposition, reverse each row to achieve the final rotated matrix.

This approach works only for **square matrices**.

---

## Java Implementation

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    // Helper function to reverse a 1D array
    public void reverse(int[] nums) {
        int start = 0, end = nums.length - 1;
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
- Time Complexity: O(n^2)
Both the transpose and reverse steps require visiting every element once.

- Space Complexity: O(1)
The rotation is done in-place with no additional space used.

### Notes
- This solution works only for square matrices (n x n).

- If a matrix is not square, this method will not apply correctly.

- Transposing and reversing is a common and elegant trick to rotate matrices.
