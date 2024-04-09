class Solution {
    public int nthUglyNumber(int n) {
        int[] dp= new int[n];
        dp[0]=1;
        int i2=0,i3=0, i5=0;
        int factor2=2,factor3=3,factor5=5;
        for(int i=1;i<n;i++){
            int min= Math.min(Math.min(factor2, factor3), factor5);
            dp[i]=min;
            if(min==factor2){
                i2++;
                factor2=dp[i2]*2;
            }
            if(min == factor3){
                i3++;
                factor3= dp[i3]*3;
            }
            if(min== factor5){
                i5++;
                factor5= dp[i5]*5;
            }
        }
        return dp[n-1];
    }
}