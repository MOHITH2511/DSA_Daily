package Arrays.MajorityElement;

import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2) 
                res = entry.getKey();
        }
        return res;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}
