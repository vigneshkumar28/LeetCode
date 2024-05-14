class Solution {
    private int dfs(int[][] grid, int m, int n, int row, int col){
        if(row<0 || col < 0 || row == m || col == n || grid[row][col] == 0)
            return 0;
        int temp = grid[row][col];
        grid[row][col]=0;
        int top = dfs(grid, m, n, row-1, col);
        int bottom = dfs(grid, m, n, row+1, col);
        int left = dfs(grid, m, n, row, col-1);
        int right = dfs(grid, m, n, row, col+1);
        grid[row][col]=temp;
        return grid[row][col]+ Math.max(Math.max(top, bottom), Math.max(left, right));
    }
    public int getMaximumGold(int[][] grid) {
        int m=grid.length; int n=grid[0].length;
        int maxGold = 0;
        for(int i=0;i<m; i++){
            for(int j=0;j<n; j++){
                maxGold = Math.max(maxGold, dfs(grid, m, n, i, j));
            }
        }
        return maxGold;
    }
}