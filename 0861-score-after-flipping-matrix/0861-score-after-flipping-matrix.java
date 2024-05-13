class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        // summation of first column
        int score = (1<<(n-1))*m;
        for(int j=1; j<n; j++){
            int countOfSameBits=0;
            for(int i=0;i<m;i++){
                if(grid[i][j] == grid[i][0])
                    countOfSameBits++;
            }
            countOfSameBits = Math.max(countOfSameBits, m-countOfSameBits);
            int columnScore = (1<<(n-j-1)) * countOfSameBits;
            score += columnScore;
        }
        return score;
    }
}