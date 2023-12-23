class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = 0;
        int n= prices.length;
        for(int i=1; i<n; i++){
            int currPrice = prices[i];
            int profit = currPrice - minPrice;
            maxPrice = Math.max(maxPrice, profit);
            minPrice = Math.min(minPrice, currPrice);
        }
        return maxPrice;
    }
}