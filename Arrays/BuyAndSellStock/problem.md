# Best Time to Buy and Sell Stock

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.

You want to maximize your profit by choosing **a single day to buy one stock** and choosing a **different day in the future to sell that stock**.

Return the **maximum profit** you can achieve from this transaction. If you cannot achieve any profit, return `0`.

---

## Example

**Input:**  
`prices = [7, 1, 5, 3, 6, 4]`  
**Output:**  
`5`  
**Explanation:**  
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.

---

## Approach

We use a greedy approach:

- Keep track of the **minimum price** seen so far while iterating through the array.
- At each step, calculate the **profit** if you were to sell on that day.
- Update the **maximum profit** whenever this profit is higher than the previous maximum.

---

## Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}
```

### Time & Space Complexity
- Time Complexity: O(n) — Single pass through the array.

- Space Complexity: O(1) — Only two variables are used for tracking minPrice and maxProfit.

### Notes
- This algorithm ensures you buy before you sell.

- If the array is sorted in descending order, profit is `0`, as no transaction is profitable.

- It's one of the most efficient solutions for this classic greedy problem.