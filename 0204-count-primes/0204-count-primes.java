class Solution {
    public int countPrimes(int n) {
        //Sieve of Eratosthenes algorithm
        if(n < 2)
            return 0;
        int count = 0;
        boolean[] dp = new boolean[n];
        for(int i=2; i<n; i++)
            dp[i]= true;
        for(int i = 2; i*i<n; i++){
            if(dp[i])
            for(int j=i*i; j<n; j=i+j){
                    dp[j] = false;
                }
            }
        for(int i=2; i<n ;i++)
            if(dp[i])
                count++;
        return count;
    }
}