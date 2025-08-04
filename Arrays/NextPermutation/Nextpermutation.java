package Arrays.NextPermutation;

import java.util.Arrays;
class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1,n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            reverse(0, n-1, nums);
            return;
        }

        for(int i = n-1;i > ind ;i--){
            if(nums[ind] < nums[i]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        reverse(ind+1, n-1, nums);
    }
    public void reverse(int start, int end, int[] nums){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

public class Nextpermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
