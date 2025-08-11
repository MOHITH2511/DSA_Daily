import java.util.*;
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
            }
            else {
                merged[idx][1] = Math.max(merged[idx][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(merged, idx + 1);
    }
}
