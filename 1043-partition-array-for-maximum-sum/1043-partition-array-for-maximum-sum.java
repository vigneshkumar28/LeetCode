class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        return recursion(arr, k, dp, 0);
    }
    private int recursion(int[] arr, int k, int[] dp, int start){
        if(start >= arr.length)
            return 0;
        if(dp[start] != -1)
            return dp[start];
        int max=0;
        int ans=0;
        int end=Math.min(arr.length, start+k);
        for(int i=start; i<end;i++){
            max = Math.max(max, arr[i]);
            ans = Math.max(ans, max*(i-start+1)+ recursion(arr, k, dp, i+1));
        }
        return dp[start]=ans;
    }
}