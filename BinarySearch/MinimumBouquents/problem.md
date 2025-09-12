# Minimum Number of Days to Make m Bouquets – Java Solution  

This repository contains a Java implementation of the **Minimum Number of Days to Make m Bouquets** problem using **Binary Search on Answer**.  

---

## Problem Statement  

You are given an integer array `bloomDay`, an integer `m`, and an integer `k`.  

- `bloomDay[i]` is the day the i-th flower blooms.  
- To make one bouquet, you need `k` adjacent flowers that have bloomed.  
- You need to make exactly `m` bouquets.  

Return the **minimum number of days** you need to wait until you can make all `m` bouquets. If it is impossible, return `-1`.  

---

### Examples  

**Example 1:**  

**Input:**  
bloomDay = [1,10,3,10,2], m = 3, k = 1


**Output:**  
3


**Explanation:**  
- Day 1: [x, _, _, _, _] → 1 bouquet  
- Day 2: [x, _, _, _, x] → 2 bouquets  
- Day 3: [x, _, x, _, x] → 3 bouquets ✅  

---

**Example 2:**  

**Input:**  
bloomDay = [1,10,3,10,2], m = 3, k = 2


**Output:**  
-1


**Explanation:**  
We need 3 bouquets of 2 adjacent flowers each → 6 flowers required, but only 5 exist. Impossible.  

---

**Example 3:**  

**Input:**  
bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3


**Output:**  
12


**Explanation:**  
- After day 7: can form only 1 valid bouquet.  
- After day 12: all flowers bloomed → 2 bouquets possible.  

---

## Solution Approach  

This is a **Binary Search on Answer** problem:  

1. If the total flowers needed (`m * k`) exceeds `n`, return `-1`.  
2. Use binary search between `min(bloomDay)` and `max(bloomDay)` to find the smallest feasible day.  
3. For each candidate day `D`, check if at least `m` bouquets can be formed:  
   - Traverse `bloomDay`.  
   - Count consecutive bloomed flowers (where `bloomDay[i] ≤ D`).  
   - Every `k` consecutive flowers → 1 bouquet.  
   - Reset count when a flower hasn’t bloomed.  
4. Narrow the search range based on feasibility.  

---

## Java Implementation  

```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1; // Prevent overflow

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
```

### Time and Space Complexity
#### Time Complexity:

- Each feasibility check takes O(n).

- Binary search runs in O(log(max(bloomDay))).

- Overall: O(n log(maxDay)).

#### Space Complexity: ####

- Only a few extra variables are used → O(1).

### -Notes

- This is a classic binary search on answer problem.

- Handles large inputs efficiently (up to 10^5 flowers).

- Special care is taken to avoid integer overflow when checking m * k.