package Arrays.MaximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(n, curMax * n);
            curMin = Math.min(n, curMin * n);
            res = Math.max(res, curMax);
        }
        return res;
    }
}


public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution solution = new Solution();
        int result = solution.maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + result);
    }
}
