package Arrays.PrintMaxSubarray;

public class MaxSubarray
{
	public static void main(String[] args) {
 		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		maxSubArray(nums);
	}
	
	public static void maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0,start = 0,end = 0,tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0){
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        for(int i = start; i <= end; i++) System.out.print(nums[i] +  " ");
    }
}
