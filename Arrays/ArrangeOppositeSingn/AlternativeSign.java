package Arrays.ArrangeOppositeSingn;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res[pos] = nums[i];
                pos += 2;
            }else{
                res[neg] = nums[i];
                neg += 2;
            }
        }
        return res;
    }
}

public class AlternativeSign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        Solution solution = new Solution();
        int[] rearranged = solution.rearrangeArray(nums);
        for (int num : rearranged) {
            System.out.print(num + " ");
        }
    }
}
