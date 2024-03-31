class Solution {
    //LCS below code
    //LPS means we need to pass s2 as reverse of s1 and remaining all are same as LCS code
    public int lcs(String s1, String s2, int m, int n,int[][] dp){
        if(m==0||n==0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1)){
             dp[m][n] = 1+lcs(s1,s2,m-1,n-1,dp);  
             return dp[m][n];
        }
        else{
            dp[m][n] = Math.max(lcs(s1,s2,m-1,n,dp), lcs(s1,s2,m,n-1,dp));
            return dp[m][n];
        } 
    }
    public int minInsertions(String s) {
        int n=s.length();
        String reverseStr = new StringBuilder(s).reverse().toString();
        int[][] dp= new int[n+1][n+1];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return n-lcs(s, reverseStr, n,n, dp);
    }
}