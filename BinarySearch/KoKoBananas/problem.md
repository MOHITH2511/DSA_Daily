# Koko Eating Bananas – Java Solution  

This repository contains a Java implementation of the **Koko Eating Bananas** problem using **Binary Search**.  

---

## Problem Statement  

Koko loves bananas. There are `piles` of bananas, and the `i-th` pile has `piles[i]` bananas. The guards have gone, and Koko has `h` hours to finish all the bananas.  

Each hour, Koko chooses a pile and eats `k` bananas from it. If the pile has fewer than `k` bananas, she eats the entire pile.  

Return the **minimum integer k** such that Koko can eat all the bananas within `h` hours.  

---

### Example  

**Input:**  
piles = [3, 6, 7, 11], h = 8  

**Output:**  
4  

**Explanation:**  
- At speed 4:  
  - Pile 3 → 1 hour  
  - Pile 6 → 2 hours  
  - Pile 7 → 2 hours  
  - Pile 11 → 3 hours  
- Total = 8 hours ✅  

---

## Solution Approach  

This problem can be solved with **Binary Search on the Answer**:  

1. The eating speed `k` must lie between `1` (minimum) and `max(piles)` (maximum).  
2. Use binary search to find the smallest valid `k`.  
3. For each mid value, calculate the total hours required.  
4. If hours ≤ `h`, it means Koko can finish, so try smaller speeds.  
5. Otherwise, increase the speed.  

---

## Java Implementation  

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE, res = 0;

        // Find the maximum pile (upper bound for binary search)
        for (int pile : piles) {
            if (max < pile) max = pile;
        }

        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            int Thour = CalculateThour(mid, piles);

            if (Thour <= h) {
                res = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;  // need higher speed
            }
        }
        return res;
    }

    // Helper function to calculate total hours for a given speed
    public int CalculateThour(int speed, int[] piles) {
        int Thour = 0;
        for (int bananas : piles) {
            Thour += Math.ceil((double) bananas / (double) speed);
        }
        return Thour;
    }
}
```


### Time and Space Complexity

*Time Complexity:*

- Binary search runs in O(log(max(piles))).

- For each mid value, we compute total hours in O(n).

- Overall: O(n · log(max(piles)))

*Space Complexity:*

- Only a few extra variables are used → O(1)

### Notes

- This is a classic binary search on answer problem.

- Works efficiently even for large inputs, since logarithmic search keeps checks minimal.

- A brute force solution would test all speeds from 1 to max, which is inefficient.