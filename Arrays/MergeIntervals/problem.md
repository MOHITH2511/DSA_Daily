# Merge Intervals in Java

This repository contains a Java implementation to **merge overlapping intervals** from a given list of intervals.

---

## Problem Statement

Given an array of intervals where each interval is represented as `[start, end]`, merge all **overlapping** intervals and return an array of the non-overlapping intervals sorted by their start time.

---

### Example

**Input:**  
intervals = [[1,3],[2,6],[8,10],[15,18]]  

**Output:**  
[[1,6],[8,10],[15,18]]  

**Explanation:**  
- The intervals `[1,3]` and `[2,6]` overlap, so they are merged into `[1,6]`.  
- The other intervals do not overlap, so they remain unchanged.

---

## Solution Approach

The solution uses a **sorting + single-pass merging** approach:

1. **Sort the intervals** by their start time.
2. Initialize the merged list with the first interval.
3. Iterate through the sorted intervals:
   - If the current interval starts **after** the end of the last merged interval, add it as a new interval.
   - Otherwise, merge it with the last interval by updating the end time to the maximum end.
4. Return the merged list.

---

## Java Implementation

```java
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] merged = new int[n][2];
        int idx = 0;
        merged[0][0] = intervals[0][0];
        merged[0][1] = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > merged[idx][1]) {
                idx++;
                merged[idx][0] = intervals[i][0];
                merged[idx][1] = intervals[i][1];
            } else {
                merged[idx][1] = Math.max(merged[idx][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(merged, idx + 1);
    }
}
```

### Time and Space Complexity
- Time Complexity: O(n log n)
  Sorting the intervals takes O(n log n), and merging them in a single pass takes O(n).

- Space Complexity: O(n)
  The merged intervals array requires extra space proportional to the number of merged intervals.

### Notes
- Sorting ensures intervals are processed in the correct order for merging.

- Works for both positive and negative interval values.

- Handles cases where intervals are nested inside one another.

- Output order will always be sorted by interval start time.
