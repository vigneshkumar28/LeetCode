class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
           dp[i] = matrix[i];
        }
        for(int row = 1; row<n; row++){
            for(int col = 0; col<n; col++){
                dp[row][col] += Math.min(dp[row-1][Math.max(0, col-1)], Math.min(dp[row-1][col], dp[row-1][Math.min(n-1, col+1)]));
            }
        }
        for(int i: dp[n-1]){
            minSum = Math.min(minSum, i);
        }
        return minSum;
    }
}