package Arrays.ArrayLeader;

import java.util.*;
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = arr.length - 1;i >= 0;i--){
            if(arr[i] >= max){
                max = arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
}

public class ArrayLeader {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(Solution.leaders(arr));
    }
}
