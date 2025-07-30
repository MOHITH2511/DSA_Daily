class Solution {
    public void rotate(int[] nums, int k) {
       int n = nums.length;
       k = k % n;
       rev(nums, 0, n-1);
       rev(nums, 0, k-1);
       rev(nums, k, n-1);
    }
    public void rev(int[] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 7;
        solution.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}