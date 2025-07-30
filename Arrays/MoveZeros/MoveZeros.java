package Arrays.MoveZeros;

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++; 
            }
            }
        while(index<nums.length)
            nums[index++] = 0;
        }
    }

public class MoveZeros {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " "); // Output: 1 3 12 0 0
        }
    }
}
