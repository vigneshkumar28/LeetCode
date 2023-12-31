class Solution {
    public int distinctSubseqII(String s) {
      int n = s.length();
      int mod = 1000000007;
      int[] dp = new int[n+1];
      int[] lastOccr = new int[26];
      Arrays.fill(lastOccr, -1);
      dp[0] = 1;
      for(int i=1;i<=n; i++){
        char cur = s.charAt(i-1);
        dp[i]= (2*dp[i-1])%mod;
        if(lastOccr[cur-'a'] != -1)
          dp[i] = (dp[i] - dp[lastOccr[cur-'a']]+mod)%mod;
        lastOccr[cur-'a']=i-1;
      }
      return (dp[n]-1+mod)%mod;
    }
}