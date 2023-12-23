class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i=1; i< prices.length; i++){
            int currPrice = prices[i];
            int profit = currPrice - prices[i-1];
            if(profit > 0)
            totalProfit += profit;
        }
        return totalProfit;
    }
}