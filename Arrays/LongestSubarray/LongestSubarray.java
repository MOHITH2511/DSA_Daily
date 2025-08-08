package Arrays.LongestSubarray;
import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(sum == k) len = Math.max(len, i + 1);

            int rem = sum - k;
            if(map.containsKey(rem)) len =Math.max(len, i - map.get(rem));

            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return len;
    }
}

public class LongestSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        int result = solution.longestSubarray(nums, k);
        System.out.println("Length of longest subarray: " + result);
    }
}
