class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                Map<Integer, Integer> prefixSumCount = new HashMap<>();
                prefixSumCount.put(0, 1);
                int currSum = 0;
                for(int k=0;k<m;k++){
                    int subMatSum = matrix[k][j] - (i>0 ? matrix[k][i-1]:0);
                    currSum += subMatSum;
                    if(prefixSumCount.containsKey(currSum - target)){
                        count += prefixSumCount.get(currSum - target);
                    }
                    prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0)+1);
                }
            }
        }
        return count;
    }
}