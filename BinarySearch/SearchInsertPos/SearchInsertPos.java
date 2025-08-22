package BinarySearch.SearchInsertPos;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid < nums.length && nums[mid] == target) return mid;
            else if(mid < nums.length && nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}

public class SearchInsertPos {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 5)); // Output: 2
        System.out.println(solution.searchInsert(nums, 2)); // Output: 1
        System.out.println(solution.searchInsert(nums, 7)); // Output: 4
        System.out.println(solution.searchInsert(nums, 0)); // Output: 0
    }
}
