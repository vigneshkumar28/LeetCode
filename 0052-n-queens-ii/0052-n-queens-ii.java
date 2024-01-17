class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] i: board){
            Arrays.fill(i, '.');
        }
        List<List<String>> result = new ArrayList<>();
        nQueuensHelper(board, 0, result);
        return result.size();
    }
    private void nQueuensHelper(char[][] board, int row, List<List<String>> result){
        if(row == board.length){
            result.add(constructRow(board));
            return;
        }
        for(int col=0; col<board.length; col++){
            if(isValid(row, col, board)){
                board[row][col] = 'Q';
                nQueuensHelper(board, row+1, result);
                board[row][col] = '.';
            }
        }
    }
    private List<String> constructRow(char[][] board){
        List<String> results = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            results.add(new String(board[i]));
        }
        return results;
    }
    private boolean isValid(int row, int col, char[][]board){
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q')
                return false;
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }
        for(int i=row, j=col; i>=0 && j< board.length; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}