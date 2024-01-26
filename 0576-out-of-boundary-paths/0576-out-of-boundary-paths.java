class Solution {
    int max = 1000000007;
    private int findPathHelper(int m, int n, int maxMove, int startRow, int startColumn, int[][][] vis){
        if(startRow ==m || startColumn == n || startRow<0 || startColumn<0)
            return 1;
        if(maxMove==0)
            return 0;
        if(vis[startRow][startColumn][maxMove] >= 0) return vis[startRow][startColumn][maxMove];
        vis[startRow][startColumn][maxMove]= (
            (findPathHelper(m,n,maxMove-1,startRow-1,startColumn,vis)+
            findPathHelper(m,n,maxMove-1,startRow+1, startColumn,vis)) % max+
            (findPathHelper(m,n,maxMove-1, startRow, startColumn-1, vis)+
            findPathHelper(m,n,maxMove-1, startRow, startColumn+1,vis))%max
        ) % max;
        return vis[startRow][startColumn][maxMove];
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] vis = new int[m][n][maxMove+1];
        for(int[][] i: vis)
            for(int[] j: i)
                Arrays.fill(j, -1);
        return findPathHelper(m,n,maxMove, startRow, startColumn, vis);
    }
}