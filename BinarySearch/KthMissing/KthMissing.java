package BinarySearch.KthMissing;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}


public class KthMissing {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int result = solution.findKthPositive(arr, k);
        System.out.println("The " + k + "th missing positive integer is: " + result);
    }
}
