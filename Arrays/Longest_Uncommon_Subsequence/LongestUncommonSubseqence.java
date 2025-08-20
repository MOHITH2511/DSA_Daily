
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}


class LongestUncommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "abc";
        String b = "def";
        int result = solution.findLUSlength(a, b);
        System.out.println("The length of the longest uncommon subsequence is: " + result);
    }
}