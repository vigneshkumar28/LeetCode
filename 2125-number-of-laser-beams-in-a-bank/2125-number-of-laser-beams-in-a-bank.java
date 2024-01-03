class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] dp = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            dp[i] = countOne(bank[i]);
        }
        int before = 0;
        for(int i: dp){
            if( i > 0){
                count += (i * before);
                before = i;
            }       
        }
        return count;
    }
    private static int countOne(String b){
        int count = 0;
        for(int i=0; i<b.length(); i++){
            if(b.charAt(i) == '1')
                count++;
        }
        return count;
    }
}