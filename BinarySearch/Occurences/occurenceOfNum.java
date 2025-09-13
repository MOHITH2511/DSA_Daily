package BinarySearch.Occurences;
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


public class occurenceOfNum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int count = sol.countFreq(arr, target);
        System.out.println("The number " + target + " occurs " + count + " times.");
    }
}