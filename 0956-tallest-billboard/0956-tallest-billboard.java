class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for(int r : rods) sum += r;
        int[] dp = new int[sum + 1];
        for(int i = 1; i < dp.length; ++i) dp[i] = -1;
        for(int rod : rods) {
            int[] prev = dp.clone();
            for(int diff = 0; diff + rod <= sum; ++diff) {
                if(prev[diff] < 0) continue;
                int nd = Math.abs(diff - rod);
                dp[nd] = Math.max(dp[nd], prev[diff] + Math.min(diff, rod));
                dp[diff + rod] = Math.max(dp[diff + rod], prev[diff]);
            }
        }
        return dp[0];
    }
}