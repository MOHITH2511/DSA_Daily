# Count Frequency of an Element in a Sorted Array – Java Solution  

This repository contains a Java implementation of the **Count Frequency of an Element in a Sorted Array** problem using **Binary Search**.  

---

## Problem Statement  

You are given a sorted integer array `arr` and a target integer `x`.  
Your task is to find how many times `x` occurs in the array.  

---

### Examples  

**Example 1:**  

**Input:**  
arr = [1,2,2,2,3,4], x = 2  

**Output:**  
3  

**Explanation:**  
Element `2` appears at indices `1,2,3`. Hence frequency = 3.  

---

**Example 2:**  

**Input:**  
arr = [1,1,2,3,5,5,5,5,6], x = 5  

**Output:**  
4  

**Explanation:**  
Element `5` appears at indices `4,5,6,7`. Hence frequency = 4.  

---

**Example 3:**  

**Input:**  
arr = [1,3,5,7,9], x = 2  

**Output:**  
0  

**Explanation:**  
Element `2` is not present in the array.  

---

## Solution Approach  

Since the array is **sorted**, we can use **binary search** to efficiently locate the first and last occurrence of the target.  

1. Use binary search to find the **first occurrence** of `x`.  
2. Use binary search to find the **last occurrence** of `x`.  
3. The frequency = `lastIndex - firstIndex + 1`.  
4. If the element is not found, return `0`.  

This avoids linear scanning and works in logarithmic time.  

---

## Java Implementation  

```java
class Solution {
    int countFreq(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0; // target not found
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }

    private int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                high = mid - 1; // keep searching left
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                low = mid + 1; // keep searching right
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
```

### Time and Space Complexity
#### Time Complexity:

- Each binary search takes `O(log n)`.

- We run it twice (first + last occurrence).

- Overall: `O(log n)`.

#### Space Complexity:

- Only a few variables used → `O(1)`.

### Notes

- Works only because the array is sorted.

- Much faster than a linear scan `(O(n))`.

- Handles large arrays efficiently.