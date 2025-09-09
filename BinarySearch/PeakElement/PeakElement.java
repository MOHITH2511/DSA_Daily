package BinarySearch.PeakElement;
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid+1]) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}

public class PeakElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,1,3,5,6,4};
        int peakIndex = solution.findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}