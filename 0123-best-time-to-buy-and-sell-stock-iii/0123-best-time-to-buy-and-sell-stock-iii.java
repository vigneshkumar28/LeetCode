class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <=1)
            return 0;
        int[] firstBuy = new int[n];
        int[] firstSell = new int[n];
        int[] secondBuy = new int[n];
        int[] secondSell = new int[n];
        firstBuy[0] = -prices[0];
        secondBuy[0] = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            firstBuy[i] = Math.max(firstBuy[i-1], -prices[i]);
            firstSell[i] = Math.max(firstSell[i-1], firstBuy[i-1]+prices[i]);
            secondBuy[i] = Math.max(secondBuy[i-1], firstSell[i] - prices[i]);
            secondSell[i] = Math.max(secondSell[i-1], secondBuy[i]+prices[i]);
        }
        return secondSell[n-1];
    }
}