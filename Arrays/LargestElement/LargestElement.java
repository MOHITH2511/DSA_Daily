class Solution {
    public int largestElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

public class LargestElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 5, 7, 2, 8, 1};
        System.out.println("Largest Element: " + solution.largestElement(arr));
    }
}
