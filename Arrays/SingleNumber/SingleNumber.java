package Arrays.SingleNumber;
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num:nums){
            res ^= num;
        }
        return res; 
    }
}

public class SingleNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 1, 2, 1, 2}; // Example input
        System.out.println("Single number: " + sol.singleNumber(nums)); // Output: 4
    }
}