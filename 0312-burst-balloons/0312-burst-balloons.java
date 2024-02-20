class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ballons = new int[n+2];
        ballons[0] = ballons[n+1]=1;
        System.arraycopy(nums, 0, ballons, 1, n);
        int[][] memo = new int[n+2][n+2];
        return burstMaxBallons(ballons, 1, n, memo);
    }
    private int burstMaxBallons(int[] ballons, int left, int right, int[][] memo){
        if(left>right)return 0;
        if(memo[left][right] > 0) return memo[left][right];
        int maxCoins=0;
        for(int i=left; i<=right;i++){
            int coins= ballons[left-1]*ballons[i]*ballons[right+1];
            int leftCoins = burstMaxBallons(ballons, left, i-1, memo);
            int rightCoins = burstMaxBallons(ballons, i+1, right, memo);
            maxCoins  =Math.max(maxCoins, coins+leftCoins+rightCoins);
        }
        memo[left][right] = maxCoins;
        return maxCoins;
    }
}