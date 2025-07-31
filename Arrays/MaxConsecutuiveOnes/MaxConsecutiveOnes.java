package Arrays.MaxConsecutuiveOnes;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for(int ele : nums){
             if(ele == 0){
                max = Math.max(max,curr);
                curr = 0;
             }else curr++;
        }
        max = Math.max(max,curr);
        return max;
    }
}

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 0, 1, 1, 1}; // Example input
        System.out.println("Max consecutive ones: " + sol.findMaxConsecutiveOnes(nums)); // Output: 3
    }
}