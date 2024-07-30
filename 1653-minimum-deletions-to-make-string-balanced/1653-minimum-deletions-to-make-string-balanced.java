class Solution {
    public int minimumDeletions(String s) {
        //dp
        int n=s.length();
        int[] dp= new int[n+1];
        int bCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'b'){
                dp[i+1]=dp[i];
                bCount++;
            }else{
                dp[i+1]=Math.min(dp[i]+1, bCount);
            }
        }
        return dp[n];
    }
}