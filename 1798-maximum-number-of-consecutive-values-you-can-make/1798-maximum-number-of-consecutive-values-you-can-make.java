class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 0;
        for(int coin : coins){
            if(coin > max+1)
                return max+1;
            
            max += coin;
        }
        return max+1;
    }
}