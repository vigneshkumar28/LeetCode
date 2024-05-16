class Solution {
    // recursion - for all possible
    // dp for reducing memory and iterations
    // binary search for optimazation
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return recursion(k, n, dp);
    }
    private int recursion(int egg, int floor, int[][] dp){
        if(egg ==1 || floor==0 || floor==1)
            return floor;
        if(dp[egg][floor] != -1)
            return dp[egg][floor];
        int ans = Integer.MAX_VALUE;
        int low = 1; int high =floor;
        while(low <= high){
            int mid = low+ (high - low) / 2;
            int eggDrops = recursion(egg-1, mid-1, dp);
            int eggSurvive = recursion(egg, floor-mid, dp);
            int worst = Math.max(eggDrops, eggSurvive)+1;
            ans = Math.min(ans, worst);
            if(eggDrops > eggSurvive){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        dp[egg][floor] = ans;
        return ans;
    }
}