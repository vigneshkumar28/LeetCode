class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        dp=new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] i: dp){
            for(int[] j: i)
            Arrays.fill(j, -1);
        }
        return dfs(grid, 0, 0, grid[0].length-1);
    }
    private int dfs(int[][] grid, int level, int i, int j){
        int rows=grid.length;
        int cols = grid[0].length;
        if(i<0 || j<0 || i>=cols || j >=cols || i==j|| level >=rows)
            return 0;
        if(dp[level][i][j] != -1)
            return dp[level][i][j];
        int max = 0;
        for(int itr1 = -1; itr1 <2; itr1++){
            for(int itr2=-1; itr2<2; itr2++){
                max = Math.max(max, dfs(grid, level+1, i+itr1, j+itr2));
            }
        }
        dp[level][i][j] = grid[level][i] + grid[level][j]+max;
        return grid[level][i] + grid[level][j]+max;
    }
}