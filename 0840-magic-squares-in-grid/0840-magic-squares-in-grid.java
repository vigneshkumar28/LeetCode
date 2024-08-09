class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int row=0;row+2<m;row++){
            for(int col =0; col+2<n; col++){
                if(isMagicSquare(grid, row, col))
                    ans++;
            }
        }
        return ans;
    }
    private boolean isMagicSquare(int[][] grid, int row, int col){
        String sequence = "2943816729438167";
        String sequenceReversed = "7618349276183492";
        StringBuilder border= new StringBuilder();
        int[] borderIndices = new int[]{0,1,2,5,8,7,6,3};
        for(int i: borderIndices){
            int num= grid[row+ i/3][col+(i%3)];
            border.append(num);
        }
        String borderConverted= border.toString();
        return (grid[row][col] %2==0 && (sequence.contains(borderConverted) || sequenceReversed.contains(borderConverted)) && grid[row+1][col+1]==5);
    }
}