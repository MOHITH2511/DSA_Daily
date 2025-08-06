package Arrays.SpiralMatrix;
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int top = 0, bottom = row - 1, right = col - 1, left = 0;
        int count = 0;
        List<Integer> li = new ArrayList<>();
        while(left<=right || top <= bottom){
            if(count == row * col) break;
            for(int i = left; i <= right; i++){
                li.add(matrix[top][i]);
                count++;
            }
            top++;
            if(count == row * col) break;
            for(int i = top; i <= bottom; i++){
                li.add(matrix[i][right]);
                count++;
            }
            right--;
            if(count == row * col) break;
            for(int i = right; i >= left; i--){
                li.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            if(count == row * col) break;
            for(int i = bottom; i >= top; i--){
                li.add(matrix[i][left]);
                count++;
            }
            left++;
            if(count == row * col) break;
        }
        return li;
    }
}

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Solution sol = new Solution();
        List<Integer> result = sol.spiralOrder(matrix);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
