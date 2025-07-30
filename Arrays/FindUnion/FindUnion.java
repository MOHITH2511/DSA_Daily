package Arrays.FindUnion;
import java.util.*;
class Solution {
    public ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i < a.length; i++) set.add(a[i]);
        for (int i = 0; i < b.length; i++) set.add(b[i]);

        for (int ele : set) union.add(ele);

        return union;
    }
}


public class FindUnion {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};
        ArrayList<Integer> result = sol.findUnion(a, b);
        System.out.println("Union of arrays: " + result); // Output: [1, 2, 3, 4, 5]
    }
}