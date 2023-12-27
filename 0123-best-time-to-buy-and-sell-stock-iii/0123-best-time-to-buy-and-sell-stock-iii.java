class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for(int price : prices){
            sell2 = Math.max(sell2, hold2+price);
            hold2 = Math.max(hold2, sell1-price);
            sell1 = Math.max(sell1, hold1 + price);
            hold1 = Math.max(hold1, -price);
        }
        return sell2;
    }
}