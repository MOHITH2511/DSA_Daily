package Arrays.BuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0,minPrice = Integer.MAX_VALUE;
        for(int price : prices){
            if(minPrice > price) minPrice = price;
            else if(price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }
}

public class SellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }
}
