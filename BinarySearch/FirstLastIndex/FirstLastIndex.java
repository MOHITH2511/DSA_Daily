package BinarySearch.FirstLastIndex;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int Findex = -1;
        int l = 0, r = nums.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid < nums.length && nums[mid] == target){
                Findex = mid;
                r = mid - 1;
            }else if(mid < nums.length && nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        int Lindex = -1;
        l = 0;
        r = nums.length;
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid < nums.length && nums[mid] == target){
                Lindex = mid;
                l = mid + 1;
            }else if(mid < nums.length && nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        res[0] = Findex;
        res[1] = Lindex;
        return res;
    }
}

public class FirstLastIndex {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("First and Last Position: " + result[0] + ", " + result[1]);
    }
}
