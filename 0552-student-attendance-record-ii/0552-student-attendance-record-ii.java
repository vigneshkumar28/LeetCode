class Solution {
    private final int MOD = 1000000007;
    //dp
    private int[][][] memo;
    public int checkRecord(int n) {
        memo = new int[n+1][2][3];
        for(int[][] arr2D: memo){
            for(int[] arr1D: arr2D){
                Arrays.fill(arr1D, -1);
            }
        }
        return eligibleCombinations(n, 0, 0);
    }
    private int eligibleCombinations(int n, int totalAbsences, int consectiveLate){
        if(totalAbsences >= 2 || consectiveLate >= 3)
            return 0;
        if(n ==0)
            return 1;
        //check already procedd or not
        if(memo[n][totalAbsences][consectiveLate] != -1)
            return memo[n][totalAbsences][consectiveLate];
        int count=0;
        //Present
        count = eligibleCombinations(n-1, totalAbsences, 0)%MOD;
        //Absent
        count =(count+eligibleCombinations(n-1, totalAbsences+1, 0))%MOD;
        //Late
        count =(count+eligibleCombinations(n-1, totalAbsences, consectiveLate+1))%MOD;
        memo[n][totalAbsences][consectiveLate] = count;
        return memo[n][totalAbsences][consectiveLate];
    }
}