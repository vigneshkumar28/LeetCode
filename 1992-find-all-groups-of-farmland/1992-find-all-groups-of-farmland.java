class Solution {
    int row2, col2;
    int[][] dirs= {{-1,0}, {0,-1},{0,1},{1,0}};
    public int[][] findFarmland(int[][] land) {
        int n=land.length;
        int m=land[0].length;
        boolean[][] visited= new boolean[n][m];
        List<int[]> ans= new ArrayList<>();
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(land[row][col]==1 && !visited[row][col]){
                    row2=0;col2=0;
                    dfs(land, visited, row, col);
                    int[] arr= new int[]{row, col, row2, col2};
                    ans.add(arr);
                }
            }
        }
        return ans.stream().toArray(int[][] :: new);
    }
    private void dfs(int[][] land, boolean[][] visited, int x, int y){
        visited[x][y]=true;
        row2= Math.max(row2, x);
        col2= Math.max(col2, y);
        for(int[] d: dirs){
            int newX= x+d[0];
            int newY= y+d[1];
            if(isWithinFarm(newX, newY, land.length, land[0].length) && !visited[newX][newY] && land[newX][newY]== 1){
                dfs(land, visited, newX, newY);
            }
        }
    }
    private boolean isWithinFarm(int x, int y, int N, int M){
        return x>=0 && x<N && y>=0 && y<M;
    }
}