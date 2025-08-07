import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();
        for(int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/3) 
                res.add(entry.getKey());
        }
        return res;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3, 2, 2, 1};
        System.out.println("Majority Elements: " + solution.majorityElement(nums));
    }
}