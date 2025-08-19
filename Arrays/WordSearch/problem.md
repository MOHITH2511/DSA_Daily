# Word Search in Java

This repository contains a Java implementation of the **Word Search** problem, solved using **Depth-First Search (DFS)** with **backtracking**.

---

## Problem Statement

Given an `m x n` grid of characters and a word, determine if the word exists in the grid.  

- The word can be formed by letters of **sequentially adjacent cells** (horizontally or vertically).  
- The same cell may **not** be used more than once.  

---

### Example

**Input:**  

board = [
['A','B','C','E'],
['S','F','C','S'],
['A','D','E','E']
]

word = "ABCCED"


**Output:**  

true


**Explanation:**  
The path `A → B → C → C → E → D` matches the target word.

---

## Solution Approach

This problem is solved using **DFS + backtracking**:

1. Start from each cell in the grid.
2. If the current cell matches the current character of the word, recursively explore its **4 neighbors** (up, down, left, right).
3. Temporarily mark the cell as visited (to avoid reuse in the same path).
4. Backtrack by restoring the cell after exploring.
5. If all characters are matched, return `true`.

---

## Java Implementation

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true; // all characters matched

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark as visited

        boolean found = dfs(board, word, i+1, j, idx+1) ||
                        dfs(board, word, i-1, j, idx+1) ||
                        dfs(board, word, i, j+1, idx+1) ||
                        dfs(board, word, i, j-1, idx+1);

        board[i][j] = temp; // restore after backtracking
        return found;
    }
}
```

### Time and Space Complexity

- Time Complexity: `O(M * N * 4^L)`

        M × N = grid size

        L = length of the word

        Each cell may branch into 4 DFS paths

- Space Complexity: O(L)

        Depth of recursion stack depends on the word length

### Notes

- The solution uses in-place modification to mark visited cells, avoiding extra memory.

- Works for any rectangular board, not just square.

- Backtracking ensures that once a path is invalid, it undoes its steps and tries alternatives.