class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++){
            dp[i] = -1;
        }
        return countOfClimbs(dp, n);
    }
    private static int countOfClimbs(int[] dp, int n){
        if( n <= 1){
            return dp[n] = 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = countOfClimbs(dp, n-1) + countOfClimbs(dp, n-2);
        return dp[n];
    }
}