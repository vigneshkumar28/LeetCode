class Solution {
    public void solveSudoku(char[][] board) {
        solveHelper(board);
    }
    private boolean solveHelper(char[][] board){
        for(int row=0; row<9; row++){
            for(int col=0;col<9; col++){
                if(board[row][col] == '.'){
                    if(updateNumber(board, row, col)){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean updateNumber(char[][] board, int row, int col){
        for(char isNum = '1'; isNum<='9'; isNum++){
            if(isValid(board, isNum, row, col)){
                board[row][col] = isNum;
                if(solveHelper(board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    private boolean isValid(char[][] board, char num, int row, int col){
        return !isNumInRow(board, num, row) && !isNumInCol(board, num, col) && !isNumInSubGrid(board, num, row, col);
    }
    private boolean isNumInRow(char[][] board, char num, int row){
        for(int i=0; i<9; i++){
            if(board[row][i] == num){
                return true;
            }
        }
        return false;
    }
    private boolean isNumInCol(char[][] board, char num, int col){
        for(int i=0; i<9; i++){
            if(board[i][col] == num){
                return true;
            }
        }
        return false;
    }
    private boolean isNumInSubGrid(char[][] board, char num, int row, int col){
        int startIndex = row - row%3;
        int endIndex = col - col%3;
        for(int i=startIndex; i<startIndex+3; i++){
            for(int j=endIndex; j<endIndex+3; j++){
                if(board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }
    
}