class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[hits.length];
        
        for(int[] hit : hits) {
            grid[hit[0]][hit[1]] *= -1;
        }
        for(int i = 0; i < m; i++) {
            dfs(grid, 0, i);
        }
        for(int i = hits.length-1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 0) {
                continue;
            } 
            grid[x][y] = 1;
            if(connected(grid, x, y, n, m)) {
                ans[i] = dfs(grid, x, y)-1;
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        return 1 + dfs(grid, x+1, y) + dfs(grid, x, y+1) + dfs(grid, x-1, y) + dfs(grid, x, y-1);
    }
    public boolean connected(int[][] grid, int x, int y, int n, int m) {
        if(x == 0) {
            return true;
        }
        if(x+1 < n) {
            if(grid[x+1][y] == 2) {
                return true;
            }
        }
        if(x-1 >= 0) {
            if(grid[x-1][y] == 2) {
                return true;
            }
        }
        if(y+1 < m) {
            if(grid[x][y+1] == 2) {
                return true;
            }
        }
        if(y-1 >= 0) {
            if(grid[x][y-1] == 2) {
                return true;
            }
        }
        return false;
    }
}