class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n= board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0||j==0||i==m-1||j==n-1) && !vis[i][j]&&board[i][j]=='O'){
                    dfs(i, j, vis, board);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int i, int j, boolean[][] vis, char[][] board){
        vis[i][j]=true;
        if(i>0 && !vis[i-1][j] && board[i-1][j] == 'O')
        dfs(i-1, j, vis, board);
        if(i<board.length-1 && !vis[i+1][j] && board[i+1][j] == 'O')
        dfs(i+1, j, vis, board);
        if(j>0 && !vis[i][j-1] && board[i][j-1] =='O')
        dfs(i, j-1, vis, board);
        if(j<board[0].length-1 && !vis[i][j+1] && board[i][j+1] == 'O')
        dfs(i, j+1, vis, board);
    }
}