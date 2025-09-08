package BinarySearch.SingleElement;
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        int n=nums.length;
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low=1;int high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid % 2==1 && nums[mid-1]==nums[mid] || mid % 2==0 && nums[mid]==nums[mid+1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}


public class SingleElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,1,2,3,3,4,4,8,8};
        int[] nums2 = {3,3,7,7,10,11,11};
        System.out.println(solution.singleNonDuplicate(nums1)); // Output: 2
        System.out.println(solution.singleNonDuplicate(nums2)); // Output: 10
    }
}