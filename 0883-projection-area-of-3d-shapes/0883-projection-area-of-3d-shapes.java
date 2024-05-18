class Solution {
    public int projectionArea(int[][] grid) {
        int N=grid.length;
        int res=0;
        for(int i=0;i<grid.length; i++){
            int row=0;
            int col=0;
            for(int j=0;j<N;j++){
                if(grid[i][j] > 0)
                    res++;
                row = Math.max(row, grid[i][j]);
                col = Math.max(col, grid[j][i]);
            }
            res += row+col;
        }
        return res;
    }
}