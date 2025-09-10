package BinarySearch.KoKoBananas;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE, res = 0;

        for(int pile : piles){
            if(max < pile) max = pile;
        }

        int left = 1, right = max;
        while(left <= right){
            int mid = (left + right) / 2;
            int Thour = CalculateThour(mid, piles);
            if(Thour <= h){
                res = mid;
                right = mid - 1;
            }else left = mid + 1;
        }
        return res;
    }

    public int CalculateThour(int i, int[] piles){
        int Thour = 0;
        for(int l = 0; l < piles.length; l++){
            Thour += Math.ceil((double) piles[l] / (double) i);
        }
        return Thour;
    }
}

public class KoKoBanana {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
