class Solution {
    int dp[][]=new int[21][5001+5000];
    public int tallestBillboard(int[] rods) {
        int  n=rods.length;
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(0,0,n,rods)/2;
    }
    public int solve(int diff,int index,int n,int []rods){
        if(index>=n){
            if(diff==0)
            return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[index][diff+5000]!=-1)
        return dp[index][diff+5000];
        
        int nottake=solve(diff,index+1,n,rods);
        int take_long=rods[index]+solve(diff+rods[index],index+1,n,rods);
        int take_short=rods[index]+solve(diff-rods[index],index+1,n,rods);
        return dp[index][diff+5000]=Math.max(nottake,Math.max(take_long,take_short));
       }
}