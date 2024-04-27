class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i <n; i++) {
            if (ring.charAt(i) == key.charAt(0)) {
                dp[0][i] = Math.min(i, n - i) + 1;
            }
        }
        for (int i = 1; i <m; i++) {
            for (int j = 0; j <n; j++) {
                if (ring.charAt(j) != key.charAt(i)) continue;
                for (int k = 0; k <n; k++) {
                    if (dp[i - 1][k] == Integer.MAX_VALUE) continue;
                    int steps = Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + steps);
                }
            }
        }
        int minSteps = Integer.MAX_VALUE;
        for (int steps : dp[m - 1]) {
            minSteps = Math.min(minSteps, steps);
        }
        
        return minSteps;
    }
}