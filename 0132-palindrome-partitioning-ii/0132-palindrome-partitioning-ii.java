class Solution {
    // private boolean isPlaindrome(String str){
    //     int start=0;
    //     int end=str.length()-1;
    //     while(start<end){
    //         if(str.charAt(start)!=str.charAt(end))
    //             return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        for(int end=0;end<n;end++){
            int minCut=end;
            for(int start=0;start<=end;start++){
                if(s.charAt(start)==s.charAt(end) && (end-start<=2 || isPalindrome[start+1][end-1])){
                 isPalindrome[start][end]=true;
                 minCut=(start == 0)?0:Math.min(minCut, dp[start-1]+1);
                }
            }
            dp[end]=minCut;
        }
        return dp[n-1];
    }
}