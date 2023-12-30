class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowHasZero = false;
        boolean colHasZero = false;
        for(int i = 0; i<n; i++){
            if(matrix[0][i] == 0){
                rowHasZero = true;
            }
        }
        for(int j = 0 ;j<m;j++){
            if(matrix[j][0] == 0){
                colHasZero = true;
            }
        }
        //set first row and first col of that respective index to zero
        int firstRowOrCol =0;
        for(int i=1; i<m; i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][firstRowOrCol] = 0;
                    matrix[firstRowOrCol][j] = 0;
                }
            }
        }
        // update inner arr expect first row and first colm updates to avoid other updates
        for(int i=1; i<m; i++){
            for(int j = 1; j <n; j++){
                if(matrix[i][0] ==0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowHasZero == true){
            for(int i = 0; i<n; i++){
                matrix[0][i] = 0;
            }
        }
        if(colHasZero == true){
            for(int j = 0;j<m;j++){
                matrix[j][0] = 0;
            }
        }

    }
}