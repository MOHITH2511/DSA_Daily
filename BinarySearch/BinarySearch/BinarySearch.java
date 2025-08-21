package BinarySearch.BinarySearch;

class Solution {
    public int search(int[] nums, int target) {
        return BinarySearch(nums, 0, nums.length - 1, target);
    }
    public int BinarySearch(int[] nums, int l, int r, int target){
        if( l > r) return -1;
        int mid = (l + r) / 2;
        if(mid < nums.length && nums[mid] == target) return mid;
        else if(mid < nums.length && nums[mid] < target) return BinarySearch(nums, mid + 1, r, target);
        else return BinarySearch(nums, l, mid - 1, target);
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
