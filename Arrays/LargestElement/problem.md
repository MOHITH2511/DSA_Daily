# Largest Element in an Array

## Problem Statement
Write a function to find the largest element in a given integer array.

## Example
**Input:** [3, 5, 7, 2, 8, 1]  
**Output:** 8

## Approach
- Initialize `max` as the first element.
- Iterate through the array starting from the second element.
- If the current element is greater than `max`, update `max`.
- Return `max` at the end.

## Time Complexity
- **O(n)** — The function iterates over all `n` elements in the array once.

## Space Complexity
- **O(1)** — No additional space is used except for a few variables.
