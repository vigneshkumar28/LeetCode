class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(backtracking(row,col,0, board, word, vis))
                    return true;
            }
        }
        return false;
    }
    private boolean backtracking(int row, int col, int id, char[][] board, String word, boolean[][] vis){
        if(id == word.length())
            return true;
        if(row<0 || row >=board.length || col<0 || col>=board[0].length || board[row][col] != word.charAt(id) || vis[row][col] ==true){
            return false;
        }
        vis[row][col]=true;
        boolean isAvailable = (
            backtracking(row, col+1, id+1, board, word, vis) ||
            backtracking(row, col-1, id+1, board, word, vis) ||
            backtracking(row+1, col, id+1, board, word, vis) ||
            backtracking(row-1, col, id+1, board, word, vis)
        );
        vis[row][col]=false;
        return isAvailable;
    }
}