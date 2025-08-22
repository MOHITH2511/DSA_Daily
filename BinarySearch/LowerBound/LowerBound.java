package BinarySearch.LowerBound;

class Solution {
    int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = arr.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] >= target){
                res = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return res;
    }
}


public class LowerBound {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2, 3, 4, 5};
        System.out.println(solution.lowerBound(arr, 2)); // Output: 1
        System.out.println(solution.lowerBound(arr, 3)); // Output: 3
        System.out.println(solution.lowerBound(arr, 0)); // Output: 0
        System.out.println(solution.lowerBound(arr, 6)); // Output: 6
    }
}
