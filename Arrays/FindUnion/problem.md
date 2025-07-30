
# Union of Two Arrays

This Java program finds the union of two arrays using a `HashSet`. The union of two arrays is a set containing all distinct elements from both arrays.

## Problem Statement

Given two arrays `a` and `b`, return an array that represents the **union** of both. The union should contain only unique elements.

### Example

```
Input:
a = [1, 2, 3]
b = [2, 4, 5]

Output:
[1, 2, 3, 4, 5]
```

## Java Code

```java
import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i < a.length; i++) set.add(a[i]);
        for (int i = 0; i < b.length; i++) set.add(b[i]);

        for (int ele : set) union.add(ele);

        return union;
    }
}
```

## Time and Space Complexity

- **Time Complexity:** O(n + m)
  - Iterates through both arrays once.
- **Space Complexity:** O(n + m)
  - Stores unique elements in a `HashSet`.

## Explanation

1. Add all elements of array `a` into a `HashSet` to ensure uniqueness.
2. Add all elements of array `b` into the same set.
3. Convert the set into a list and return it.

This approach ensures that duplicate elements are removed and the union contains all unique elements from both arrays.
