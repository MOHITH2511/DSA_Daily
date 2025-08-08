package Arrays.SubarraySum;
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, cnt = 0;
        for(int num : nums){
            sum += num;
            int rem = sum - k;
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}

public class SubarraySum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println("Number of subarrays: " + result);
    }
}
