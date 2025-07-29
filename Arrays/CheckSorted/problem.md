# Check if Array is Sorted and Rotated

## Problem Statement
Given an array of integers, check whether the array is sorted and then rotated.  
An array is considered sorted and rotated if it is possible to rotate it some number of times so that it becomes a non-decreasing sorted array.

## Example
**Input:** [3, 4, 5, 1, 2]  
**Output:** true

## Approach
- Loop through the array and count how many times `nums[i] > nums[(i+1) % n]`.
- If the count is more than 1, return false.
- Else, return true.

## Time Complexity
- **O(n)** – Single pass through the array.

## Space Complexity
- **O(1)** – Constant extra space used.
