# Remove Duplicates from Sorted Array

## Problem Statement
Given a sorted array `nums`, remove the duplicates **in-place** such that each unique element appears only once and return the new length.

## Example
**Input:** [1, 1, 2, 2, 3]  
**Output:**  
New Length: 3  
Array: [1, 2, 3]

## Approach
- Use two pointers: `i` to traverse, `j` to keep track of unique values.
- Whenever a new unique value is found, place it at index `j+1`.

## Time Complexity
- **O(n)** – Each element is processed once.

## Space Complexity
- **O(1)** – In-place modification without using extra space.
