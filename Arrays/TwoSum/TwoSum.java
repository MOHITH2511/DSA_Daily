package Arrays.TwoSum;
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0;i < nums.length;i++){
        int tar = target - nums[i];
        if(map.containsKey(tar)) return new int[]{map.get(tar),i};
        else map.put(nums[i],i);
       }
       return new int[]{};
    }
}


public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15}; // Example input
        int target = 9; // Example target
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices of the two numbers that add up to " + target + ": " + Arrays.toString(result));
    }
}