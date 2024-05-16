class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k+1];
        int ans=0;
        while(dp[k] < n){
            for(int i=k;i>0;i--){
                dp[i] += dp[i-1]+1;
            }
            ans++;
        }
        return ans;
    }
}