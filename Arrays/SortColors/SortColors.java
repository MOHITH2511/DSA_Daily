package Arrays.SortColors;
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, i = 0;
        int zc = 0, oc = 0, tc = 0; // Counters for 0s, 1s, and 2s
        
        // First pass: Count occurrences
        while(i < n){
            if(nums[i] == 0) zc++;
            else if(nums[i] == 1) oc++;
            else if(nums[i] == 2) tc++;
            i++;
        }

        // Second pass: Overwrite array
        i = 0;
        while(i < n){
            if(zc != 0) {
                nums[i] = 0;
                zc--;
            } else if(oc != 0){
                nums[i] = 1;
                oc--;
            } else if(tc != 0){
                nums[i] = 2;
                tc--;
            }
            i++;
        }
    }
}

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}