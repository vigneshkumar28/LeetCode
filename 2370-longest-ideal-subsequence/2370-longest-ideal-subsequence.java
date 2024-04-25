class Solution {
    public int longestIdealString(String s, int k) {
        int N = s.length();
        int[] dp = new int[26];
        int maxLength = 0;
        for (int i = 0; i < N; i++){
            int curr = s.charAt(i)-'a';
            int best = 0;
            for (int prev = 0; prev < 26; prev++) {
                if (Math.abs(prev - curr) <= k) {
                    best = Math.max(best, dp[prev]);
                }
            }
            dp[curr] = Math.max(dp[curr], best + 1);
            maxLength = Math.max(maxLength, dp[curr]);
        }
        return maxLength;
    }
}