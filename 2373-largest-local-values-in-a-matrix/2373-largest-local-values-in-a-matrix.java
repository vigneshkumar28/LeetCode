class Solution {
    public int[][] largestLocal(int[][] grid) {
        int N= grid.length;
        int[][] maxLocal= new int[N-2][N-2];
        for(int i=0;i<N-2;i++){
            for(int j=0;j<N-2;j++){
                maxLocal[i][j] = maxInGrid(grid, i, j);
            }
        }
        return maxLocal;
    }
    private int maxInGrid(int[][] grid, int a, int b){
        int max=0;
        for(int i=a; i<a+3; i++){
            for(int j=b;j<b+3; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}