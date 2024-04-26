class Solution {
    public int minFallingPathSum(int[][] grid) {
        int indexPreviousMinimum=0;
        int previousMinimum=0;
        int previousSecondMinimum=0;
       
        for(int i=0;i< grid.length;i++){  
             int indexCurrentMinimum=0;
             int currentMinimum=Integer.MAX_VALUE;
             int secondCurrentMinimum=Integer.MAX_VALUE;                  
            for(int j=0;j< grid.length;j++){        
                int current=(j==indexPreviousMinimum)?previousSecondMinimum+grid[i][j]:previousMinimum+grid[i][j];  
                if(current<currentMinimum){
                    secondCurrentMinimum=currentMinimum;
                    indexCurrentMinimum=j;
                    currentMinimum=current;
                }else{
                    secondCurrentMinimum=Math.min(current,secondCurrentMinimum);
                } 
            }
            indexPreviousMinimum=indexCurrentMinimum;
            previousSecondMinimum=secondCurrentMinimum;
            previousMinimum=currentMinimum;
        }
        return previousMinimum;
    }
}