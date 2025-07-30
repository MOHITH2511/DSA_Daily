package Arrays.MissingNumber;
class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;
        int total = (n + 1) * (n + 2) / 2; // Sum of first n natural numbers
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Calculate the sum of the array elements
        }

        return total - sum; 
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 4, 5}; // Example input
        System.out.println("Missing number: " + sol.missingNum(arr)); // Output: 3
    }
}